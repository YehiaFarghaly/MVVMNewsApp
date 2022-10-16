package com.androiddevs.mvvmnewsapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.androiddevs.mvvmnewsapp.Article

@Dao
interface ArticlesDao {
    @Insert(onConflict=OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article):Long

    @Query("select * from articles")
    fun getArticles():LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)

}