package com.hcid.app.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.hcid.app.domain.common.Resource
import com.hcid.app.domain.entity.Article
import com.hcid.app.domain.entity.Product
import com.hcid.app.domain.usecase.HomeUseCase

class HomeViewModel(homeUseCase: HomeUseCase):ViewModel() {
    val products:LiveData<Resource<List<Product>>> = homeUseCase.getListProducts().asLiveData()
    val articles:LiveData<Resource<List<Article>>> = homeUseCase.getListArticles().asLiveData()
    val articleSectionTitle:LiveData<Resource<String>> = homeUseCase.getArticleSectionTitle().asLiveData()
}