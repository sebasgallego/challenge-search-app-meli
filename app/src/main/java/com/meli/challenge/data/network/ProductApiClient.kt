package com.meli.challenge.data.network

import com.meli.challenge.data.model.ProductResponse
import com.meli.challenge.utils.GlobalsVar.GET_PRODUCTS
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApiClient {
    @GET(GET_PRODUCTS)
    suspend fun getProducts(@Query("q") nameProduct: String): Response<ProductResponse>

}