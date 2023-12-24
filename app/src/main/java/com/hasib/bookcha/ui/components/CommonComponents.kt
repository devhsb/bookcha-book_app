package com.hasib.bookcha.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.hasib.bookcha.R

//Home Appbar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookchaAppBar() {
    TopAppBar(
        title = {
            Image(
                painter = painterResource(id = R.drawable.appbar_title),
                contentDescription = stringResource(R.string.bookcha_title),
                modifier = Modifier.size(120.dp)
            )
        },

        actions = {
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = stringResource(R.string.search_icon)
                )
            }
        },
    )
}

//Details App bar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsAppbar(
    onBackButton: () -> Unit
) {
    TopAppBar(
        title = {
            IconButton(onClick = onBackButton) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.back_button)
                )
            }
        }
    )
}

// card
@Composable
fun BookCard(
    modifier: Modifier = Modifier,
    bookImage: String,
    bookTitle: String,
    bookAuther: String,
    publishedDate: String,
    onBookPressed: (bookId: Int, bookRowIndex: Int) -> Unit,
    bookId: Int,
    bookRowIndex: Int
) {

    Card(
        modifier = Modifier
            .width(150.dp)
            .height(250.dp)
            .padding(10.dp)
            .clickable { onBookPressed(bookId, bookRowIndex) },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onPrimary
        ),
        elevation = CardDefaults.cardElevation(7.dp)
    ) {
        Column {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(bookImage)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentScale = ContentScale.FillBounds
            )
            Text(
                text = bookTitle,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(5.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Text(
                    text = bookAuther,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = publishedDate,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.End
                )
            }
        }
    }
}


//
////@Preview
//@Composable
//fun CardPreview(){
//    BookCard(
//        bookImage = "",
//        bookTitle = "Test Book",
//        bookAuther = "N/A",
//        publishedDate = "2023"
//    )
//}










