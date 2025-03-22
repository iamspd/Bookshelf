package com.example.bookshelf.data

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.Item
import com.example.bookshelf.model.SearchResult
import com.example.bookshelf.network.BooksApiService

interface BooksRepository {
    suspend fun searchBooks(): SearchResult
    suspend fun getBook(item: Item): Book
}

class NetworkBookRepository(
    private val booksApiService: BooksApiService
) : BooksRepository {

    private val bookType = "jazz+history"
    override suspend fun searchBooks(): SearchResult {
        return booksApiService.searchBooks(type = bookType)
    }

    override suspend fun getBook(item: Item): Book {
        return booksApiService.getBook(id = item.id)
    }


}