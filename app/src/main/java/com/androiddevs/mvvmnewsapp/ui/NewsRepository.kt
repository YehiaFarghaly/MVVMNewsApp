package com.androiddevs.mvvmnewsapp.ui

import androidx.room.Query
import com.androiddevs.mvvmnewsapp.API.RetrofitInstance
import com.androiddevs.mvvmnewsapp.Article
import com.androiddevs.mvvmnewsapp.NewsResponse
import com.androiddevs.mvvmnewsapp.database.ArticleDatabase
import retrofit2.Response

class NewsRepository(val db:ArticleDatabase) {

    suspend fun getBreakingNews(countryCode:String, pageNumber:Int):Response<NewsResponse> =
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)

    suspend fun searchNews(searchQuery: String,pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun insert(article: Article){
        db.getArticleDao().insert(article)
    }
     fun getSaved() = db.getArticleDao().getArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)



}