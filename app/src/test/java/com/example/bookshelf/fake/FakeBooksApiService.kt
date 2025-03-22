package com.example.bookshelf.fake

import com.example.bookshelf.model.Book
import com.example.bookshelf.network.BooksApiService

class FakeBooksApiService: BooksApiService {
    override suspend fun getBookThumbnails(type: String): Book {
        return FakeDataSource.book
    }
}