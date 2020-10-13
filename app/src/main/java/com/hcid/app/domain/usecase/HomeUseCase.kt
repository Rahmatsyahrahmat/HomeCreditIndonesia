package com.hcid.app.domain.usecase

import com.hcid.app.domain.common.Resource
import com.hcid.app.domain.entity.Article
import com.hcid.app.domain.entity.Product
import kotlinx.coroutines.flow.Flow

interface HomeUseCase {
    fun getArticleSectionTitle(): Flow<Resource<String>>
    fun getListArticles(): Flow<Resource<List<Article>>>
    fun getListProducts(): Flow<Resource<List<Product>>>
}