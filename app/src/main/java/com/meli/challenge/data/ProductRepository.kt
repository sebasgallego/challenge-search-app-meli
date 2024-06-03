package com.meli.challenge.data

import com.meli.challenge.data.model.ProductResponse
import com.meli.challenge.data.network.ProductService
import retrofit2.Response
import javax.inject.Inject

class ProductRepository @Inject constructor(private val apiService : ProductService) {

    suspend fun getProducts(nameProduct: String): Response<ProductResponse> {
            return apiService.getProducts(nameProduct)
    }

}