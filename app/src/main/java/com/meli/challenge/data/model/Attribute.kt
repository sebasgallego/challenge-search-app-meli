package com.meli.challenge.data.model

import com.google.gson.annotations.SerializedName

/**
 * Clase que representa un atributo de un producto.
 *
 * @property id Identificador del atributo.
 * @property valueName Nombre del valor del atributo.
 */
class Attribute {

    var id: String = ""

    @SerializedName("value_name")
    var valueName: String = ""
}

/**
 * Enumeración que representa los diferentes tipos de atributos de un producto.
 */
internal enum class AttributeType {
    BRAND, LINE, MODEL, SUB_MODEL, ITEM_CONDITION;

    /**
     * Sobrescribe el método toString para devolver una representación en cadena del tipo de atributo.
     */
    override fun toString(): String {
        return when (this) {
            LINE -> "LINE"
            BRAND -> "BRAND"
            MODEL -> "MODEL"
            SUB_MODEL -> "SUBMODEL"
            ITEM_CONDITION -> "ITEM_CONDITION"
        }
    }
}
