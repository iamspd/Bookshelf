package com.example.bookshelf.network

import com.example.bookshelf.model.Book
import retrofit2.http.GET

interface BooksApiService {
    @GET
    suspend fun getBookThumbnails() : Book
}