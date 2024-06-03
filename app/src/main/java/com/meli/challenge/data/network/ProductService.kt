package com.meli.challenge.data.network

import com.meli.challenge.data.model.ProductResponse
import retrofit2.Response
import javax.inject.Inject

class ProductService @Inject constructor(private val apiClient: ProductApiClient) {

    suspend fun getProducts(nameProduct: String): Response<ProductResponse> {
        return apiClient.getProducts(nameProduct)
    }

}