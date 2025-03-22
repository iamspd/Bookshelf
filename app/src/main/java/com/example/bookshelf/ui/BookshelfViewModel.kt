package com.example.bookshelf.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelf.BookshelfApplication
import com.example.bookshelf.data.BooksRepository
import com.example.bookshelf.model.Book
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

sealed interface AppUiState {
    data object Loading : AppUiState
    data class Success(val book: Book) : AppUiState
    data object Error : AppUiState
}

class BookshelfViewModel(
    private val booksRepository: BooksRepository
) : ViewModel() {

    var appUiState: AppUiState by mutableStateOf(AppUiState.Loading)
        private set

    init {
        getBooksFromRepository()
    }

    fun getBooksFromRepository() {

        viewModelScope.launch {
            appUiState = try {
                AppUiState.Success(book = booksRepository.getBooks())
            } catch (e: IOException) {
                AppUiState.Error
            } catch (e: HttpException) {
                AppUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
                        as BookshelfApplication
                val booksRepository = application.container.booksRepository
                BookshelfViewModel(booksRepository = booksRepository)
            }
        }
    }
}