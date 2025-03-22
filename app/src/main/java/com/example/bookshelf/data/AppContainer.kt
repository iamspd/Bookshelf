package com.example.bookshelf.data

import com.example.bookshelf.network.BooksApiService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

interface AppContainer {
    val booksRepository: BooksRepository
}

class DefaultContainer : AppContainer {
    private val baseUrl = "https://www.googleapis.com/books/v1/"

    private val retrofitService = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    private val retrofit = retrofitService.create(BooksApiService::class.java)

    override val booksRepository: BooksRepository by lazy {
        NetworkBookRepository(retrofit)
    }
}