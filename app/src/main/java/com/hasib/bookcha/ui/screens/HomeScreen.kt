package com.hasib.bookcha.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hasib.bookcha.model.BookchaModel
import com.hasib.bookcha.ui.bookchaViewModel.BookchaUiState
import com.hasib.bookcha.ui.bookchaViewModel.BookchaViewModel
import com.hasib.bookcha.ui.components.BookchaAppBar
import com.hasib.bookcha.ui.components.BookchaTabLayout

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    books: MutableList<BookchaModel>,
    onBookPressed: (bookId: Int, booksRowIndex: Int) -> Unit,
    isLoading: Boolean,
    uiState: BookchaUiState,
    viewModel: BookchaViewModel
) {
    HomeScreenComponents(
        books = books, onBookPressed = onBookPressed, isLoading = isLoading,
        viewModel = viewModel
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenComponents(
    modifier: Modifier = Modifier,
    books: MutableList<BookchaModel>,
    onBookPressed: (bookId: Int, booksRowIndex: Int) -> Unit,
    isLoading: Boolean,
    viewModel: BookchaViewModel,
) {
    Scaffold(
        topBar = {
            BookchaAppBar()
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues)
        ) {
            BookchaTabLayout(
                books = books,
                onBookPressed = onBookPressed,
                isLoading = isLoading,
                viewModel = viewModel,
            )
        }
    }
}














