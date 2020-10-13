package com.hcid.app.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("product_name")
    val name:String,
    @SerializedName("product_image")
    val image:String,
    val link:String
)