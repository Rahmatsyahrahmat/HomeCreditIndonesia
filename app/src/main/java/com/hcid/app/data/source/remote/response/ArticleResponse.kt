package com.hcid.app.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ArticleResponse(
    @SerializedName("article_title")
    val title:String,
    @SerializedName("article_image")
    val image:String,
    val link:String
)