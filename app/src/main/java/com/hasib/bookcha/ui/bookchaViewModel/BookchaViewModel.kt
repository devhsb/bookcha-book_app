package com.hasib.bookcha.ui.bookchaViewModel

import android.util.Log
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hasib.bookcha.data.ListOfBooks
import com.hasib.bookcha.model.BookchaModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException

class BookchaViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(BookchaUiState())
    val uiState: StateFlow<BookchaUiState>
        get() = _uiState.asStateFlow()

    var verticalListState: LazyGridState by mutableStateOf(LazyGridState(0, 0))
    var horizontalListState: LazyListState by mutableStateOf(LazyListState(0, 0))
    var selectedTabState by mutableStateOf(0)

    //getData when app start
    init {
        getBooks()
    }

    //get initial books
    fun getBooks(): List<BookchaModel> {
        viewModelScope.launch {
            try {
                updateUi(
                    books = ListOfBooks.getListOFBooks(),
                    isLoading = false,
                )

            } catch (e: IOException) {
                Log.d("TAG", "getBooks: Error occured")
            }
        }
        return uiState.value.books
    }

    //update ui data
    fun updateUi(
        books: MutableList<BookchaModel>,
        isHomePage: Boolean = true,
        isLoading: Boolean = false,
        bookId: Int = 0,
        booksRowIndex: Int = 0
    ) {
        _uiState.update { currentState ->
            currentState.copy(
                books = books,
                isHomePage = isHomePage,
                isLoading = isLoading,
                bookId = bookId,
                booksRowIndex = booksRowIndex
            )
        }
    }


    //reset ui
    fun resetUi(
        isHomePage: Boolean
    ) {
        _uiState.update {
            it.copy(isHomePage = isHomePage)
        }
    }

    //update book query
    fun updateQuery(
        bookQuery: String
    ) {
        _uiState.update {
            it.copy(
                booksQuery = bookQuery
            )
        }
    }
}