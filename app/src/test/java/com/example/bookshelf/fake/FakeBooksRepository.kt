package com.example.bookshelf.fake

import com.example.bookshelf.data.BooksRepository
import com.example.bookshelf.model.Book

class FakeBooksRepository: BooksRepository {
    override suspend fun getBooks(): Book {
        return FakeDataSource.book
    }
}