package com.meli.challenge.data.model

import com.google.gson.annotations.SerializedName

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
class Product {

    var id: String = ""
    var title: String = ""
    var thumbnail: String = ""
    var price: Double = 0.0

    @SerializedName("available_quantity")
    var availableQuantity: Int = 0

    @SerializedName("sold_quantity")
    var soldQuantity: Int = 0

    var installments: Installment? = null
    private var attributes: ArrayList<Attribute>? = null

    /**
     * Obtiene el valor de un atributo específico del producto.
     *
     * @param type Tipo de atributo a buscar.
     * @return El valor del atributo si se encuentra, de lo contrario una cadena vacía.
     */
    fun getItemAttributes(type: String): String {
        var value = ""
        attributes?.let {
            for (item: Attribute in it) {
                if (type == item.id) {
                    value = item.valueName
                    break
                }
            }
        }
        return value
    }
}
