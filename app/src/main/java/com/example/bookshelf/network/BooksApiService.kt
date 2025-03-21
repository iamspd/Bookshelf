package com.example.bookshelf.network

import com.example.bookshelf.model.Book
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApiService {

    @GET("volumes")
    suspend fun getBookThumbnails(
        @Query("q") type: String
    ): Book
}