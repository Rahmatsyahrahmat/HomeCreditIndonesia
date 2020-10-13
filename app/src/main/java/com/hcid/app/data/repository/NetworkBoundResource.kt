package com.hcid.app.data.repository

import com.hcid.app.data.source.remote.network.ApiResponse
import com.hcid.app.domain.common.Resource
import kotlinx.coroutines.flow.*

abstract class NetworkBoundResource<ResultType,RequestType> {

    private val result:Flow<Resource<ResultType>> = flow {
        val dbSource = loadFromDB().first()
        emit(Resource.Loading(dbSource))
        if (shouldFetch(dbSource)){
            when(val apiResponse = createCall().first()){
                is ApiResponse.Success ->{
                    saveCallResult(apiResponse.data)
                    emitAll(
                        loadFromDB().map {
                            Resource.Success(it)
                        }
                    )
                }
                is ApiResponse.Empty ->{
                    emitAll(
                        loadFromDB().map {
                            Resource.Success(it)
                        }
                    )
                }
                is ApiResponse.Error ->{
                    emit(
                        Resource.Error<ResultType>(
                            apiResponse.message
                        )
                    )
                }
            }
        }else{
            emitAll(
                loadFromDB().map {
                    Resource.Success(it)
                }
            )
        }
    }

    protected abstract fun loadFromDB(): Flow<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>

    protected abstract suspend fun saveCallResult(data: RequestType)

    fun asFlow() = result

}