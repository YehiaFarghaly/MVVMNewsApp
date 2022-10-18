package com.androiddevs.mvvmnewsapp.utils


// sealed class is the same as abstract classes but you determine which classes are allowed to inherit from it
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T):Resource<T>(data)
    class Error<T>(message: String,data: T?=null):Resource<T>(data,message)
    class Loading<T>:Resource<T>()
}