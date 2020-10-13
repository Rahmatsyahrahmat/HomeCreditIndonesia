package com.hcid.app.data.source.remote

import com.hcid.app.data.source.remote.helper.GsonHelper
import com.hcid.app.data.source.remote.network.ApiResponse
import com.hcid.app.data.source.remote.network.ApiService
import com.hcid.app.data.source.remote.response.ArticleResponse
import com.hcid.app.data.source.remote.response.ProductResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource constructor(private val apiService: ApiService){

    suspend fun getArticles() = flow {
        try {
            val response = apiService.getHomeData().data.find {
                it.section == "articles"
            }?.items
            if (response.isNullOrEmpty()){
                emit(ApiResponse.Empty)
            }else{
                emit(ApiResponse.Success(GsonHelper.toObjectListOf(response,ArticleResponse::class.java)))
            }
        }catch (e:Exception){
            emit(ApiResponse.Error(e.message.toString()))
        }

    }.flowOn(Dispatchers.IO)

    suspend fun getProducts() = flow {
        try {
            val response = apiService.getHomeData().data.find {
                it.section == "products"
            }?.items
            if (response.isNullOrEmpty()){
                emit(ApiResponse.Empty)
            }else{
                emit(ApiResponse.Success(GsonHelper.toObjectListOf(response,ProductResponse::class.java)))
            }
        }catch (e:Exception){
            emit(ApiResponse.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    suspend fun getArticleSectionTitle() = flow {
        try {
            val response = apiService.getHomeData().data.find {
                it.section == "articles"
            }?.sectionTitle
            if (response.isNullOrEmpty()){
                emit(ApiResponse.Empty)
            }else{
                emit(ApiResponse.Success(response))
            }
        }catch (e:Exception){
            emit(ApiResponse.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

}