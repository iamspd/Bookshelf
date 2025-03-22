package com.example.bookshelf.fake

import com.example.bookshelf.data.NetworkBookRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkBookRepositoryTest {

    @Test
    fun networkBookRepositoryTest_getBooks_verifyBookData() = runTest {
        val repository = NetworkBookRepository(
            booksApiService = FakeBooksApiService()
        )

        assertEquals(FakeDataSource.book, repository.getBooks())
    }
}