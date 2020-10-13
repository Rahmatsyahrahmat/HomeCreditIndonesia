package com.hcid.app.data.mapper

import com.hcid.app.data.source.local.product.ProductEntity
import com.hcid.app.data.source.remote.response.ProductResponse
import com.hcid.app.domain.entity.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

fun Flow<List<ProductEntity>>.asProducts() =
    this.map {
        it.asProducts()
    }

fun List<ProductEntity>.asProducts() =
    this.map {
        it.asProduct()
    }

fun ProductEntity.asProduct() =
    Product(
        this.name,
        this.image,
        this.link
    )

fun List<ProductResponse>.asEntities() =
    this.map {
        it.asEntity()
    }

fun ProductResponse.asEntity() =
    ProductEntity(
        this.name,
        this.image,
        this.link
    )