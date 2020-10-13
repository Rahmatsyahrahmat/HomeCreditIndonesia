package com.hcid.app.data.source.local

import com.hcid.app.data.source.local.article.ArticleDao
import com.hcid.app.data.source.local.article.ArticleEntity
import com.hcid.app.data.source.local.product.ProductDao
import com.hcid.app.data.source.local.product.ProductEntity

class LocalDataSource (
    private val articleDao: ArticleDao,
    private val productDao: ProductDao,
    private val preference:PreferenceHelper
){

    fun getAllArticles() = articleDao.selectAllArticles()

    suspend fun insertArticles(articles:List<ArticleEntity>) = articleDao.insertArticles(articles)

    fun getAllProducts() = productDao.selectAllProducts()

    suspend fun insertProducts(products:List<ProductEntity>) = productDao.insertProducts(products)

    fun getArticleSectionTitle() = preference.getArticleSectionTitle()

    fun setArticleSectionTitle(title:String) = preference.setArticleSectionTitle(title)

}