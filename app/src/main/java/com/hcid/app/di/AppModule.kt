package com.hcid.app.di

import com.hcid.app.domain.usecase.HomeUseCase
import com.hcid.app.domain.usecase.HomeUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideHomeUseCase(homeUseCaseImpl: HomeUseCaseImpl):HomeUseCase

}