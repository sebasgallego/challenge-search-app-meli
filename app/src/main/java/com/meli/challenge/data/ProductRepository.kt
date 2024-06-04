package com.meli.challenge.data

import com.meli.challenge.data.model.ProductResponse
import com.meli.challenge.data.network.ProductService
import retrofit2.Response
import javax.inject.Inject

/**
 * Repositorio para manejar las operaciones relacionadas con productos.
 *
 * @property apiService Servicio de productos, inyectado mediante Dagger/Hilt.
 */
class ProductRepository @Inject constructor(private val apiService: ProductService) {

    /**
     * Método suspendido para obtener productos basado en el nombre del producto.
     *
     * @param nameProduct Nombre del producto para buscar.
     * @return Una respuesta de Retrofit que contiene un `ProductResponse`.
     */
    suspend fun getProducts(nameProduct: String): Response<ProductResponse> {
        return apiService.getProducts(nameProduct)
    }
}
