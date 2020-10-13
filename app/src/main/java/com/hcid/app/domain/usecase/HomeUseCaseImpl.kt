package com.hcid.app.domain.usecase

import com.hcid.app.domain.common.Resource
import com.hcid.app.domain.entity.Article
import com.hcid.app.domain.entity.Product
import com.hcid.app.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

class HomeUseCaseImpl(private val homeRepository: HomeRepository):HomeUseCase {
    override fun getArticleSectionTitle(): Flow<Resource<String>> =
        homeRepository.getArticleSectionTitle()

    override fun getListArticles(): Flow<Resource<List<Article>>> =
        homeRepository.getListArticles()

    override fun getListProducts(): Flow<Resource<List<Product>>> =
        homeRepository.getListProducts()

}