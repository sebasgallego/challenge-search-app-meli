package com.meli.challenge.data.model

import android.os.Parcel
import android.os.Parcelable
import com.meli.challenge.utils.NumberHelper
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

/**
 * Clase que representa un producto.
 *
 * @property id Identificador del producto.
 * @property title Título del producto.
 * @property thumbnail URL de la imagen en miniatura del producto.
 * @property price Precio del producto.
 * @property availableQuantity Cantidad disponible del producto.
 * @property soldQuantity Cantidad vendida del producto.
 * @property installments Información sobre las cuotas de financiamiento del producto.
 * @property attributes Lista de atributos del producto.
 */

/**
 * Obtiene el valor de un atributo específico del producto.
 *
 * @param type Tipo de atributo a buscar.
 * @return El valor del atributo si se encuentra, de lo contrario una cadena vacía.
 */

@Parcelize
data class Product(
    val id: String,
    val title: String,
    val thumbnail: String,
    val price: Double,
    val availableQuantity: Int,
    val soldQuantity: Int,
    val installments: Installment?,
    val attributes: List<Attribute>?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readParcelable(Installment::class.java.classLoader),
        parcel.createTypedArrayList(Attribute),
    )

    companion object : Parceler<Product> {

        override fun Product.write(parcel: Parcel, flags: Int) {
            parcel.writeString(id)
            parcel.writeString(title)
            parcel.writeString(thumbnail)
            parcel.writeDouble(price)
            parcel.writeInt(availableQuantity)
            parcel.writeInt(soldQuantity)
            parcel.writeParcelable(installments, flags)
            parcel.writeTypedList(attributes)
        }

        override fun create(parcel: Parcel): Product {
            return Product(parcel)
        }
    }

    fun getItemAttributes(type: String): String {
        var value = ""
        attributes?.let {
            for (item: Attribute in it) {
                if (type == item.id) {
                    value = item.valueName!!
                    break
                }
            }
        }
        return value
    }

    fun getPriceFormat(price:Double): String? {
        return  NumberHelper().parseAmountToCOP(price)
    }

}
