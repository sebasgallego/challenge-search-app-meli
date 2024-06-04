package com.meli.challenge.utils

import java.math.RoundingMode
import java.text.DecimalFormat

/**
 * Clase de utilidad para realizar operaciones relacionadas con números.
 */
class NumberHelper {

    /**
     * Método para formatear un monto en formato de moneda COP (pesos colombianos).
     *
     * @param amount El monto a formatear.
     * @return El monto formateado como una cadena de texto.
     */
    fun parseAmountToCOP(amount: Double): String? {
        // Crear un objeto DecimalFormat para formatear el número.
        val dec = DecimalFormat("#,###")

        // Establecer el modo de redondeo a techo (round up).
        dec.roundingMode = RoundingMode.CEILING

        // Formatear el monto y devolverlo como una cadena de texto.
        return dec.format(amount)
    }
}
