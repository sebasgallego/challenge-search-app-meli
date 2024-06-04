package com.meli.challenge.data.model

import com.google.gson.annotations.SerializedName

/**
 * Clase que representa la respuesta del API de productos.
 *
 * @property results Lista de productos obtenidos en la respuesta.
 */
data class ProductResponse(
    @SerializedName("results") var results: ArrayList<Product>
)
