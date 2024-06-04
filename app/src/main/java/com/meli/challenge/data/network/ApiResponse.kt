package com.meli.challenge.data.network

import java.net.HttpURLConnection

/**
 * Clase genérica que representa la respuesta de una llamada a la API.
 *
 * @param T Tipo de dato del cuerpo de la respuesta.
 * @property httpCode Código HTTP de la respuesta (por defecto HTTP_OK).
 * @property body Cuerpo de la respuesta (puede ser null).
 * @property errorMessage Mensaje de error en caso de que la llamada falle (puede ser null).
 */
data class ApiResponse<T>(
    var httpCode: Int = HttpURLConnection.HTTP_OK,
    var body: T? = null,
    var errorMessage: String? = null,
)
