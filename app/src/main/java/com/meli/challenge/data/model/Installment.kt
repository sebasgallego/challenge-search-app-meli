package com.meli.challenge.data.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Clase que representa una cuota de financiamiento.
 *
 * @property quantity Número de cuotas.
 * @property amount Monto de cada cuota.
 */
data class Installment(
    var quantity: Int,
    var amount: Double,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readDouble()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(quantity)
        parcel.writeDouble(amount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Installment> {
        override fun createFromParcel(parcel: Parcel): Installment {
            return Installment(parcel)
        }

        override fun newArray(size: Int): Array<Installment?> {
            return arrayOfNulls(size)
        }
    }
}
