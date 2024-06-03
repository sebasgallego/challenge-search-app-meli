package com.meli.challenge.data.model

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("results") var results: ArrayList<Product>
)