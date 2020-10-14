package com.hcid.app.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.hcid.app.domain.common.Resource
import com.hcid.app.domain.entity.Article
import com.hcid.app.domain.entity.Product
import com.hcid.app.domain.usecase.HomeUseCase

class HomeViewModel @ViewModelInject constructor(private val homeUseCase: HomeUseCase):ViewModel() {
    fun getProducts():LiveData<Resource<List<Product>>> = homeUseCase.getListProducts().asLiveData()
    fun getArticles():LiveData<Resource<List<Article>>> = homeUseCase.getListArticles().asLiveData()
    fun getArticleSectionTitle():LiveData<Resource<String>> = homeUseCase.getArticleSectionTitle().asLiveData()
}