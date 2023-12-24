package com.hasib.bookcha.ui.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hasib.bookcha.model.BookchaModel
import com.hasib.bookcha.ui.LazyLists.HorizontalList
import com.hasib.bookcha.ui.LazyLists.VerticalList
import com.hasib.bookcha.ui.bookchaViewModel.BookchaUiState
import com.hasib.bookcha.ui.bookchaViewModel.BookchaViewModel

@Composable
fun BookchaTabLayout(
    modifier: Modifier = Modifier,
    books: MutableList<BookchaModel>,
    onBookPressed: (bookId: Int, booksRowIndex: Int) -> Unit,
    isLoading: Boolean,
    viewModel: BookchaViewModel,
    uiState: BookchaUiState = BookchaUiState(),
) {
    val titles = listOf(
        "Newest",
        "Free",
        "Paid"
    )
//    var tabIndex by remember { mutableStateOf(0) }

    Column {

        ScrollableTabRow(
            selectedTabIndex = viewModel.selectedTabState,
            modifier = Modifier.fillMaxWidth(),
            //edgePadding = 5.dp
        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = {
                        Text(
                            text = title
                        )
                    },
                    selected = viewModel.selectedTabState == index,
                    onClick = {
                        viewModel.selectedTabState = index
                    }
                )
            }
        }

        /*
            book list indexes:
                0-4 -> different category for home-screen
                5   -> free e-books
                6   -> paid e-books
         */
        when (viewModel.selectedTabState) {
            0 -> Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(ScrollState(1))
            ) {
                val bookCategory = listOf(
                    "Business & Finance",
                    "Science",
                    "Romance",
                    "Fashion",
                    "Technology",
                )

                    for ((index, value) in bookCategory.withIndex()) {
                        HorizontalBookList(
                            books = books,
                            onBookPressed = onBookPressed,
                            isLoading = isLoading,
                            viewModel = viewModel,
                            listTitle = value,
                            booksRowIndex = index,
                        )
                }
            }

            1 -> {
                VerticalBookList(
                    books = books[5],
                    onBookPressed = onBookPressed,
                    isLoading = isLoading,
                    viewModel = viewModel,
                    booksRowIndex = 5
                )
            }

            2 -> {
                VerticalBookList(
                    books = books[6],
                    onBookPressed = onBookPressed,
                    isLoading = isLoading,
                    viewModel = viewModel,
                    booksRowIndex = 6
                )
            }
        }
    }
}

//horizontal book list
@Composable
private fun HorizontalBookList(
    modifier: Modifier = Modifier,
    books: List<BookchaModel>,
    onBookPressed: (bookId: Int, booksRowIndex: Int) -> Unit,
    isLoading: Boolean,
    viewModel: BookchaViewModel,
    listTitle: String,
    booksRowIndex: Int
) {
    Column(
        modifier = Modifier.padding(10.dp, 20.dp)
    ) {
        Text(
            text = listTitle,
            style = MaterialTheme.typography.headlineLarge
        )
        HorizontalList(
            books = books,
            onBookPressed = onBookPressed,
            isLoading = isLoading,
            viewModel = viewModel,
            booksRowIndex = booksRowIndex
        )
    }
}

//vertical book list
@Composable
private fun VerticalBookList(
    modifier: Modifier = Modifier,
    books: BookchaModel,
    onBookPressed: (bookId: Int, booksRowIndex: Int) -> Unit,
    isLoading: Boolean,
    viewModel: BookchaViewModel,
    booksRowIndex: Int,
) {
    Column(
        modifier = Modifier.padding(10.dp, 20.dp)
    ) {
        VerticalList(
            books = books,
            onBookPressed = onBookPressed,
            isLoading = isLoading,
            viewModel = viewModel,
            booksRowIndex = booksRowIndex
        )
    }
}


//@Preview(showBackground = true)
//@Composable
//fun HomepagePreview() {
//    BookchaTabLayout(
//        books = BookchaModel(
//            items = listOf(
//                Items(
//                    volumeInfo = VolumeInfo(
//                        title = "Book Title",
//                    )
//                ),
//                Items(
//                    volumeInfo = VolumeInfo(
//                        title = "Book Title",
//                    )
//                ),
//                Items(
//                    volumeInfo = VolumeInfo(
//                        title = "Book Title",
//                    )
//                ),
//                Items(
//                    volumeInfo = VolumeInfo(
//                        title = "Book Title",
//                    )
//                )
//            )
//        ), onBookPressed = {}, isLoading = false, viewModel = viewModel()
//    )
//}












