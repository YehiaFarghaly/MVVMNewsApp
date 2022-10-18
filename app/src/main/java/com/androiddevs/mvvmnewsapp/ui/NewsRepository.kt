package com.androiddevs.mvvmnewsapp.ui

import com.androiddevs.mvvmnewsapp.API.RetrofitInstance
import com.androiddevs.mvvmnewsapp.NewsResponse
import com.androiddevs.mvvmnewsapp.database.ArticleDatabase
import retrofit2.Response

class NewsRepository(val db:ArticleDatabase) {

    suspend fun getBreakingNews(countryCode:String, pageNumber:Int):Response<NewsResponse> =
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)

}