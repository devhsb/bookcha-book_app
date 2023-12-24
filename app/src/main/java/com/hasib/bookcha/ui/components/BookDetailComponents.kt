package com.hasib.bookcha.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.hasib.bookcha.R
import com.hasib.bookcha.ui.animations.shimmerEffect

@Composable
fun BookDetailComponent(
    modifier: Modifier = Modifier,
    bookImage: String = "",
    bookTitle: String = "",
    bookDescription: String = "N/A",
    averageRating: Float,
    pageCount: Int,
    author: String

) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        BookCover(
            bookImage = bookImage, bookTitle = bookTitle
        )
        BookInfo(averageRating = averageRating, pageCount = pageCount, author = author)
        BookDescriptionAndBuy(
            bookDescription = bookDescription
        )
    }
}

//Book cover
@Composable
private fun BookCover(
    modifier: Modifier = Modifier,
    bookImage: String,
    bookTitle: String,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current).data(bookImage)
                .data(bookImage)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground).crossfade(true)
                .crossfade(true)
                .build(),
            contentDescription = stringResource(R.string.thumbnail),
            modifier = Modifier
                .width(150.dp)
                .height(200.dp)
                .padding(bottom = 5.dp)
        )

        Text(
            text = bookTitle,
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center
        )
    }
}

//book info
@Composable
private fun BookInfo(
    modifier: Modifier = Modifier,
    averageRating: Float,
    pageCount: Int,
    author: String
) {
    Row(
        modifier = modifier
            .clip(
                shape = RoundedCornerShape(
                    8.dp
                )
            )
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BookInfoComp(
            infoTitle = "Rating", infoText = averageRating.toString(),
        )
        BookInfoComp(
            infoTitle = "Pages", infoText = pageCount.toString(),
        )
        BookInfoComp(
            infoTitle = "Auther", infoText = author,
        )
    }
}

@Composable
private fun BookInfoComp(
    modifier: Modifier = Modifier, infoTitle: String, infoText: String
) {
    Column(
        modifier = modifier.padding(10.dp)
    ) {
        Text(
            text = infoTitle, style = MaterialTheme.typography.labelMedium
        )

        Text(
            text = infoText, style = MaterialTheme.typography.labelLarge
        )
    }
}


//book Description and button
@Composable
private fun BookDescriptionAndBuy(
    modifier: Modifier = Modifier, bookDescription: String
) {
    Column(
        modifier = modifier.padding(vertical = 10.dp)
    ) {
        Text(
            text = bookDescription,
            textAlign = TextAlign.Justify,
            maxLines = 5,
            overflow = TextOverflow.Ellipsis,
            lineHeight = 20.sp,
            fontSize = 12.sp
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .wrapContentHeight(Alignment.Bottom)
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(10.dp))
            ) {
                Text(
                    text = "Download",
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}



//@Preview
//@Composable
//fun Preview() {
//    BookDetailComponent(
//        bookTitle = "Hello",
//        bookDescription = "Intended for those who already know the Java language, this book will help programmers get the most out of Javas capabilities. Topics covered include: good Java style for reusable components, using Java beans, the JDBC, optimizing and testing code, using the IFC tools, and the new JFC. It also explores the significant and exciting developments in Java and covers techniques that will be fundamental to programmers developing significant applications in Java."
//    )
//}
//
//
//


