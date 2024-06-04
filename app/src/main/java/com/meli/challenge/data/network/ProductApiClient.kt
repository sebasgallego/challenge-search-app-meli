package com.meli.challenge.data.network

import com.meli.challenge.data.model.ProductResponse
import com.meli.challenge.utils.GlobalsVar.GET_PRODUCTS
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Interfaz para definir las llamadas a la API relacionadas con productos.
 */
interface ProductApiClient {

    /**
     * Método para obtener productos basado en el nombre del producto.
     *
     * @param nameProduct Nombre del producto para buscar.
     * @return Una respuesta de Retrofit que contiene un `ProductResponse`.
     */
    @GET(GET_PRODUCTS)
    suspend fun getProducts(@Query("q") nameProduct: String): Response<ProductResponse>
}
