package com.hasib.bookcha.ui.LazyLists

import android.util.Log
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hasib.bookcha.model.BookchaModel
import com.hasib.bookcha.ui.animations.HorizontalShimmerEffect
import com.hasib.bookcha.ui.animations.VerticalShimmerEffect
import com.hasib.bookcha.ui.bookchaViewModel.BookchaViewModel
import com.hasib.bookcha.ui.components.BookCard

//vertical Grid list
@Composable
fun VerticalList(
    modifier: Modifier = Modifier,
    books: BookchaModel,
    onBookPressed: (bookId: Int, booksRowIndex: Int) -> Unit,
    isLoading: Boolean,
    viewModel: BookchaViewModel,
    booksRowIndex: Int,
) {
    VerticalShimmerEffect(
        isLoading = isLoading, contentAfterLoading = {
            LazyVerticalGrid(
                state = viewModel.verticalListState,
                columns = GridCells.Adaptive(150.dp)
            ) {
                items(books.items.size) { bookIndex ->
                    Log.d("TAG", "VerticalList: ${books.items.size}")
                    val currentBook = books.items[bookIndex].volumeInfo
                    BookCard(
                        bookTitle = currentBook.title,
                        bookAuther = currentBook.authors[0],
                        bookImage = currentBook.imageLinks.thumbnail,
                        publishedDate = currentBook.publishedDate,
                        onBookPressed = onBookPressed,
                        bookId = bookIndex,
                        bookRowIndex = booksRowIndex
                    )
                }

            }
        })
}

// Horizontal list
@Composable
fun HorizontalList(
    modifier: Modifier = Modifier,
    books: List<BookchaModel>,
    onBookPressed: (bookId: Int, bookRowIndex: Int) -> Unit,
    isLoading: Boolean,
    booksRowIndex: Int,
    viewModel: BookchaViewModel
) {
    HorizontalShimmerEffect(isLoading = isLoading, contentAfterLoading = {
        LazyRow(
//            state = viewModel.horizontalListState
        ) {
            items(books[booksRowIndex].items.size) { bookIndex ->
                val currentBook = books[booksRowIndex].items[bookIndex].volumeInfo
                BookCard(
                    bookTitle = currentBook.title,
                    bookAuther = currentBook.authors[0],
                    bookImage = currentBook.imageLinks.thumbnail,
                    publishedDate = currentBook.publishedDate,
                    onBookPressed = onBookPressed,
                    bookId = bookIndex,
                    bookRowIndex = booksRowIndex
                )
            }
        }
    })
}

















