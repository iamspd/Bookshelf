package com.example.bookshelf.fake

import com.example.bookshelf.rules.TestDispatcherRule
import com.example.bookshelf.ui.AppUiState
import com.example.bookshelf.ui.BookshelfViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class BookshelfViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun bookShelfViewModel_getBooks_verifyBookUiStateSuccess() = runTest {
        val bookShelfViewModel = BookshelfViewModel(
            booksRepository = FakeNetworkBooksRepository()
        )
        assertEquals(
            AppUiState.Success(listOf(FakeDataSource.book)),
            bookShelfViewModel.appUiState
        )
    }
}