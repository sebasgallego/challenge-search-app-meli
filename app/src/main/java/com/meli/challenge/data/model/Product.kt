package com.meli.challenge.data.model

import com.google.gson.annotations.SerializedName


class Product {
    var name: String = ""
    var origin: String = ""

    @SerializedName("affection_level")
    var affectionLevel: Int = 0

    @SerializedName("reference_image_id")
    var referenceImageId: String = ""
    var intelligence: Int = 0

}
