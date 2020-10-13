package com.hcid.app.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hcid.app.data.source.local.article.ArticleDao
import com.hcid.app.data.source.local.article.ArticleEntity
import com.hcid.app.data.source.local.product.ProductDao
import com.hcid.app.data.source.local.product.ProductEntity

@Database(
    entities = [ArticleEntity::class,ProductEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase(){

    abstract fun articleDao():ArticleDao
    abstract fun productDao():ProductDao

}