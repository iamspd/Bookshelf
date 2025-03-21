package com.example.bookshelf.data

import com.example.bookshelf.model.Book
import com.example.bookshelf.network.BooksApiService

interface BooksRepository {
    suspend fun getBooks(): Book
}

class NetworkBookRepository(
    private val booksApiService: BooksApiService
) : BooksRepository {

    override suspend fun getBooks(): Book {
        return booksApiService.getBookThumbnails()
    }
}