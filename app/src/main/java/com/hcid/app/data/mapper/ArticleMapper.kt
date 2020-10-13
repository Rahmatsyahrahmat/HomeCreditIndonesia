package com.hcid.app.data.mapper

import com.hcid.app.data.source.local.article.ArticleEntity
import com.hcid.app.data.source.remote.response.ArticleResponse
import com.hcid.app.domain.entity.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

fun Flow<List<ArticleEntity>>.asArticles() =
    this.map {
        it.asArticles()
    }

fun List<ArticleEntity>.asArticles() =
    this.map {
        it.asArticle()
    }

fun ArticleEntity.asArticle() =
    Article(
        this.title,
        this.image,
        this.link
    )

fun List<ArticleResponse>.asEntities() =
    this.map {
        it.asEntity()
    }

fun ArticleResponse.asEntity() =
    ArticleEntity(
        this.title,
        this.image,
        this.link
    )