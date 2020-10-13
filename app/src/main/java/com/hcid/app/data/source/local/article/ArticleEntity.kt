package com.hcid.app.data.source.local.article

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArticleEntity(
    val title:String,
    val image:String,
    @PrimaryKey
    val link:String
)