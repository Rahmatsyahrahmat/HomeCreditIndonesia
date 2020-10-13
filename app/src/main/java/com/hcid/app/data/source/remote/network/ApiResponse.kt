package com.hcid.app.data.source.remote.network

sealed class ApiResponse<out T> {
    data class Success<out T>(val data:T):ApiResponse<T>()
    data class Error(val message:String):ApiResponse<Nothing>()
    object Empty:ApiResponse<Nothing>()
}