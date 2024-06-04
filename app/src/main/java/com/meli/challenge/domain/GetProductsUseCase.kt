package com.meli.challenge.domain

import com.meli.challenge.data.ProductRepository
import com.meli.challenge.data.model.ProductResponse
import com.meli.challenge.data.network.ApiResponse
import java.io.IOException
import java.net.HttpURLConnection
import javax.inject.Inject

/**
 * Caso de uso para obtener productos.
 *
 * @property repository Repositorio de productos.
 */
class GetProductsUseCase @Inject constructor(private val repository: ProductRepository) {

    /**
     * Método suspendido para obtener productos basado en el nombre del producto.
     *
     * @param nameProduct Nombre del producto para buscar.
     * @return Una [ApiResponse] que contiene una lista de productos o un mensaje de error.
     */
    suspend operator fun invoke(nameProduct: String): ApiResponse<ProductResponse> {
        try {
            // Llamar al método del repositorio para obtener productos.
            val response = repository.getProducts(nameProduct)

            // Verificar si la respuesta fue exitosa.
            if (response.isSuccessful) {
                val body = response.body()

                // Verificar si el cuerpo de la respuesta no es null.
                if (body != null) {
                    return ApiResponse(body = body)
                }
            }
            // Crear una respuesta de error con el mensaje de la respuesta y el código HTTP.
            return ApiResponse(
                errorMessage = response.message(),
                httpCode = response.code(),
                body = null
            )
        } catch (e: IOException) {
            // Crear una respuesta de error en caso de una excepción de network.
            return ApiResponse(
                errorMessage = e.message ?: e.toString(),
                httpCode = HttpURLConnection.HTTP_UNAVAILABLE
            )
        } catch (e: Exception) {
            // Crear una respuesta de error en caso de una excepción no controlada.
            return ApiResponse(
                errorMessage = e.message ?: e.toString(),
                httpCode = HttpURLConnection.HTTP_INTERNAL_ERROR
            )
        }
    }
}
