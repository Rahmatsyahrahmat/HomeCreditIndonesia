package com.hcid.app.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class DataResponse(
    val section:String,
    @SerializedName("section_title")
    val sectionTitle:String?,
    val items:List<Any>
)