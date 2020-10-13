package com.hcid.app.data.source.local

import com.hcid.app.data.source.local.article.ArticleDao
import com.hcid.app.data.source.local.article.ArticleEntity
import com.hcid.app.data.source.local.product.ProductDao
import com.hcid.app.data.source.local.product.ProductEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(
    private val articleDao: ArticleDao,
    private val productDao: ProductDao,
    private val preferences:PreferencesHelper
){

    fun getAllArticles() = articleDao.selectAllArticles()

    suspend fun insertArticles(articles:List<ArticleEntity>) = articleDao.insertArticles(articles)

    fun getAllProducts() = productDao.selectAllProducts()

    suspend fun insertProducts(products:List<ProductEntity>) = productDao.insertProducts(products)

    fun getArticleSectionTitle() = preferences.getArticleSectionTitle()

    suspend fun setArticleSectionTitle(title:String) = preferences.setArticleSectionTitle(title)

}