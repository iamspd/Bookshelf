package com.example.bookshelf.fake

import com.example.bookshelf.data.BooksRepository
import com.example.bookshelf.model.Book
import com.example.bookshelf.model.Item
import com.example.bookshelf.model.SearchResult

class FakeNetworkBooksRepository : BooksRepository {

    override suspend fun searchBooks(): SearchResult {
        return FakeDataSource.searchResult
    }

    override suspend fun getBook(item: Item): Book {
        return FakeDataSource.book
    }
}