package com.hasib.bookcha.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hasib.bookcha.ui.animations.FadeEffect
import com.hasib.bookcha.ui.bookchaViewModel.BookchaViewModel
import com.hasib.bookcha.ui.screens.BookDetailScreen
import com.hasib.bookcha.ui.screens.HomeScreen

@Composable
fun BookchaApplication(
    modifier: Modifier = Modifier
) {
    val bookchaViewModel: BookchaViewModel = viewModel()
    val bookchaUiState by bookchaViewModel.uiState.collectAsState()

    Box {
        if (bookchaUiState.isHomePage) {
            FadeEffect {
                HomeScreen(
                    books = bookchaUiState.books,
                    onBookPressed = { bookId, booksRowIndex ->
                        bookchaViewModel.updateUi(
                            isHomePage = false,
                            books = bookchaUiState.books,
                            bookId = bookId,
                            booksRowIndex = booksRowIndex
                        )
                    },
                    isLoading = bookchaUiState.isLoading,
                    uiState = bookchaUiState,
                    viewModel = bookchaViewModel
                )
            }
        } else {
            FadeEffect {
                BookDetailScreen(
                    books = bookchaUiState.books,
                    uiState = bookchaUiState,
                    onBackButton = { bookchaViewModel.resetUi(true) }
                )
            }
        }
    }

}