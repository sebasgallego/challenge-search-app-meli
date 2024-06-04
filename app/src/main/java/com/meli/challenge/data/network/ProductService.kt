package com.meli.challenge.data.network

import com.meli.challenge.data.model.ProductResponse
import retrofit2.Response
import javax.inject.Inject

/**
 * Servicio para manejar las operaciones relacionadas con productos.
 *
 * @property apiClient Cliente de la API de productos, inyectado mediante Dagger/Hilt.
 */
class ProductService @Inject constructor(private val apiClient: ProductApiClient) {

    /**
     * Método suspendido para obtener productos basado en el nombre del producto.
     *
     * @param nameProduct Nombre del producto para buscar.
     * @return Una respuesta de Retrofit que contiene un `ProductResponse`.
     */
    suspend fun getProducts(nameProduct: String): Response<ProductResponse> {
        return apiClient.getProducts(nameProduct)
    }
}
