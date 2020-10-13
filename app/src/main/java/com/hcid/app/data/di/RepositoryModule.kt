package com.hcid.app.data.di

import com.hcid.app.data.repository.HomeRepositoryImpl
import com.hcid.app.domain.repository.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule{

    @Binds
    abstract fun provideHomeRepository(homeRepositoryImpl: HomeRepositoryImpl):HomeRepository

}