package com.meli.challenge.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.meli.challenge.utils.NumberHelper
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

@Parcelize
data class Product(
    val id: String,
    val title: String,
    val thumbnail: String,
    val price: Double,
    @SerializedName("available_quantity")
    val availableQuantity: Int,
    val installments: Installment?,
    val attributes: List<Attribute>?,
) : Parcelable {

    /**
     * Obtiene el valor de un atributo específico del producto basado en su tipo.
     *
     * @param type El tipo del atributo que se desea obtener.
     * @return El valor del atributo como una cadena de texto.
     */
    fun getItemAttributes(type: String): String {
        var value = ""
        // Verificar si la lista de atributos no es nula
        attributes?.let {
            // Iterar a través de los atributos para encontrar el que coincide con el tipo dado
            for (item: Attribute in it) {
                if (type == item.id) {
                    // Asignar el valor del atributo y salir del bucle
                    value = item.valueName ?: ""
                    break
                }
            }
        }
        return value
    }

    /**
     * Formatea el precio a la moneda colombiana (COP).
     *
     * @param price El precio a formatear.
     * @return El precio formateado como una cadena de texto.
     */
    fun getPriceFormat(price: Double): String? {
        return NumberHelper().parseAmountToCOP(price)
    }

}
