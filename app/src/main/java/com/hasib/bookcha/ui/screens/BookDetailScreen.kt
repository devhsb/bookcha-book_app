package com.hasib.bookcha.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hasib.bookcha.model.BookchaModel
import com.hasib.bookcha.ui.bookchaViewModel.BookchaUiState
import com.hasib.bookcha.ui.components.BookDetailComponent
import com.hasib.bookcha.ui.components.DetailsAppbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookDetailScreen(
    modifier: Modifier = Modifier,
    books: List<BookchaModel>,
    uiState: BookchaUiState,
    onBackButton: () -> Unit

) {
    Scaffold(
        topBar = {
            DetailsAppbar(onBackButton)
        }
    ) {
        BackHandler {
            onBackButton()
        }

        val currentBook = books[uiState.booksRowIndex].items[uiState.bookId].volumeInfo
        BookDetailComponent(
            modifier = modifier.padding(it),
            bookImage = currentBook.imageLinks.smallThumbnail,
            bookTitle = currentBook.title,
            bookDescription = currentBook.description,
            averageRating = currentBook.averageRating,
            pageCount = currentBook.pageCount,
            author = currentBook.authors[0]

        )
    }
}

