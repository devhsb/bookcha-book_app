package com.hasib.bookcha.ui.bookchaViewModel

import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import com.hasib.bookcha.model.BookchaModel

data class BookchaUiState(
    var books: MutableList<BookchaModel> = mutableListOf(),
    var booksQuery: String = "Fashion",
    var isHomePage: Boolean = true,
    var isLoading: Boolean = true,
    var bookId: Int = 0,
    var booksRowIndex: Int = 0
)