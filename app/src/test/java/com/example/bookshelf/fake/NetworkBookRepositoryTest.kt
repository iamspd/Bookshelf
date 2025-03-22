package com.example.bookshelf.fake

import com.example.bookshelf.data.NetworkBookRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkBookRepositoryTest {
    @Test
    fun networkBooksRepository_getBooks_verifyBookData() = runTest {
        val repository = NetworkBookRepository(
            booksApiService = FakeBooksApiService()
        )

        val searchedBooks = async { repository.searchBooks() }.await()
        assertEquals(FakeDataSource.book, repository.getBook(searchedBooks.items[0]))
    }
}