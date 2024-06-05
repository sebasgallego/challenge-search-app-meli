package com.meli.challenge.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Clase que representa un atributo de un producto.
 *
 * @property id Identificador del atributo.
 * @property valueName Nombre del valor del atributo.
 */
data class Attribute (
    var id: String?,
    @SerializedName("value_name")
    var valueName: String? ,
): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(valueName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Attribute> {
        override fun createFromParcel(parcel: Parcel): Attribute {
            return Attribute(parcel)
        }

        override fun newArray(size: Int): Array<Attribute?> {
            return arrayOfNulls(size)
        }
    }

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
