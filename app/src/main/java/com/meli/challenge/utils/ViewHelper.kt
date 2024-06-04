package com.meli.challenge.utils

import android.app.Activity
import com.meli.challenge.R
import java.net.HttpURLConnection.HTTP_UNAVAILABLE

/**
 * Clase de utilidad para manejar la lógica relacionada con la vista.
 *
 * @param activity La actividad asociada.
 */
class ViewHelper(activity: Activity) {

    // La actividad asociada.
    private var mActivity: Activity? = activity

    // Inicialización, establece la actividad asociada.
    init {
        mActivity = activity
    }

    /**
     * Procesa el código de error y devuelve un mensaje correspondiente.
     *
     * @param code El código de error.
     * @return Un mensaje de error correspondiente al código.
     */
    fun processMsgError(code: Int): String {
        return when (code) {
            // Si el código es HTTP_UNAVAILABLE, se devuelve el mensaje de error de internet.
            HTTP_UNAVAILABLE -> mActivity!!.getString(R.string.error_internet)
            // Para otros códigos de error, se devuelve el mensaje de error del servidor.
            else -> {
                mActivity!!.getString(R.string.error_server)
            }
        }
    }
}
