package com.meli.challenge.domain


import com.meli.challenge.data.ProductRepository
import com.meli.challenge.data.model.Product
import com.meli.challenge.data.network.ApiResponse
import java.io.IOException
import java.net.HttpURLConnection
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val repository: ProductRepository) {

    suspend operator fun invoke(nameProduct: String): ApiResponse<ArrayList<Product>> {
        try {
            val response = repository.getProducts(nameProduct)
            if (response.isSuccessful) {
                val body = response.body()
                 if (body != null)
                     return ApiResponse(
                         httpCode = response.code(),
                         body = body.results
                     )
            }
            return ApiResponse(
                errorMessage = response.message(),
                httpCode = response.code(),
                body = null
            )
        } catch (e: IOException) {
            return ApiResponse(
                errorMessage = e.message ?: e.toString(),
                httpCode = HttpURLConnection.HTTP_UNAVAILABLE
            )
        } catch (e: Exception) {
            return ApiResponse(
                errorMessage = e.message ?: e.toString(),
                httpCode = HttpURLConnection.HTTP_INTERNAL_ERROR
            )
        }
    }
}