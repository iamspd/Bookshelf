package com.example.bookshelf.fake

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.SearchResult
import com.example.bookshelf.network.BooksApiService

class FakeBooksApiService : BooksApiService {
    override suspend fun searchBooks(type: String): SearchResult {
        return FakeDataSource.searchResult
    }

    override suspend fun getBook(id: String): Book {
        return FakeDataSource.book
    }

}