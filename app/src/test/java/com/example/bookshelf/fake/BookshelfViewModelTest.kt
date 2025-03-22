package com.example.bookshelf.fake

import com.example.bookshelf.rules.TestDispatcherRule
import com.example.bookshelf.ui.AppUiState
import com.example.bookshelf.ui.BookshelfViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Assert.assertEquals
import org.junit.Test

class BookshelfViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun bookShelfViewModel_getBooksFromRepository_verifyAppUiStateSuccess() = runTest {
        val bookshelfViewModel = BookshelfViewModel(
            booksRepository = FakeBooksRepository()
        )

        assertEquals(
            AppUiState.Success(FakeDataSource.book),
            bookshelfViewModel.appUiState
        )
    }
}