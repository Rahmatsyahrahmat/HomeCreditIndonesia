package com.hcid.app.data.source.local.product

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductEntity(
    val name:String,
    val image:String,
    @PrimaryKey
    val link:String
)