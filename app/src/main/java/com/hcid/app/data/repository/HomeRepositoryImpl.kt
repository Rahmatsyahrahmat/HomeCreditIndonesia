package com.hcid.app.data.repository

import com.hcid.app.data.mapper.asArticles
import com.hcid.app.data.mapper.asEntities
import com.hcid.app.data.mapper.asProducts
import com.hcid.app.data.source.local.LocalDataSource
import com.hcid.app.data.source.remote.RemoteDataSource
import com.hcid.app.data.source.remote.network.ApiResponse
import com.hcid.app.data.source.remote.response.ArticleResponse
import com.hcid.app.data.source.remote.response.ProductResponse
import com.hcid.app.domain.common.Resource
import com.hcid.app.domain.entity.Article
import com.hcid.app.domain.entity.Product
import com.hcid.app.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepositoryImpl(private val local:LocalDataSource,private val remote:RemoteDataSource) : HomeRepository{

    override fun getArticleSectionTitle(): Flow<Resource<String>> =
        object :NetworkBoundResource<String,String>(){
            override fun loadFromDB(): Flow<String> =
                flow {
                    local.getArticleSectionTitle()
                }

            override fun shouldFetch(data: String?): Boolean =
                data.isNullOrEmpty()

            override suspend fun createCall(): Flow<ApiResponse<String>> =
                remote.getArticleSectionTitle()

            override suspend fun saveCallResult(data: String) {
                local.setArticleSectionTitle(data)
            }

        }.asFlow()

    override fun getListArticles(): Flow<Resource<List<Article>>> =
        object: NetworkBoundResource<List<Article>,List<ArticleResponse>>(){
            override fun loadFromDB(): Flow<List<Article>> =
                local.getAllArticles().asArticles()

            override fun shouldFetch(data: List<Article>?): Boolean =
                data.isNullOrEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<ArticleResponse>>> =
                 remote.getArticles()

            override suspend fun saveCallResult(data: List<ArticleResponse>) {
                local.insertArticles(data.asEntities())
            }

        }.asFlow()

    override fun getListProducts(): Flow<Resource<List<Product>>> =
        object :NetworkBoundResource<List<Product>,List<ProductResponse>>(){
            override fun loadFromDB(): Flow<List<Product>> =
                local.getAllProducts().asProducts()

            override fun shouldFetch(data: List<Product>?): Boolean =
                data.isNullOrEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<ProductResponse>>> =
                remote.getProducts()

            override suspend fun saveCallResult(data: List<ProductResponse>) {
                local.insertProducts(data.asEntities())
            }

        }.asFlow()

}