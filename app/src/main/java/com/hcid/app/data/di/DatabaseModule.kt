package com.hcid.app.data.di

import android.content.Context
import androidx.room.Room
import com.hcid.app.data.source.local.AppDatabase
import com.hcid.app.data.source.local.PreferenceHelper
import com.hcid.app.data.source.local.article.ArticleDao
import com.hcid.app.data.source.local.product.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context):AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "HomeCreditId.db"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideArticleDao(database:AppDatabase):ArticleDao = database.articleDao()

    @Provides
    fun provideProductDao(database:AppDatabase):ProductDao = database.productDao()

    @Provides
    fun providePreference(@ApplicationContext context: Context):PreferenceHelper = PreferenceHelper(context)

}