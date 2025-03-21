package com.example.bookshelf.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookshelf.R
import com.example.bookshelf.model.Book
import com.example.bookshelf.model.Books
import com.example.bookshelf.model.ImageLink
import com.example.bookshelf.model.VolumeInfo
import com.example.bookshelf.ui.theme.BookShelfTheme

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    BookShelfTheme {
        val books = List(9) {
            Books(
                id = "$it",
                imageLinks = ImageLink(imgSrc = ""),
                volumeInfo = VolumeInfo(title = "Abc")
            )
        }
        HomeScreen(
            modifier = Modifier.fillMaxSize(),
            book = Book(books = books)
        )
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    book: Book,
    paddingValues: PaddingValues = PaddingValues(0.dp)
) {
    LazyVerticalGrid(
        modifier = modifier,
        contentPadding = paddingValues,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        columns = GridCells.Adaptive(minSize = dimensionResource(R.dimen.book_thumbnail_width)),
    ) {
        items(book.books, key = { book -> book.id }) { book ->
            BookGridThumbnail(
                imageUrl = book.imageLinks.imgSrc,
                title = book.volumeInfo.title
            )
        }
    }
}

@Composable
fun BookGridThumbnail(
    imageUrl: String,
    title: String
) {
    AsyncImage(
        modifier = Modifier.height(dimensionResource(R.dimen.book_thumbnail_height)),
        model = ImageRequest.Builder(context = LocalContext.current)
            .data(data = imageUrl)
            .crossfade(enable = true)
            .build(),
        placeholder = painterResource(R.drawable.loading_img),
        error = painterResource(R.drawable.ic_broken_image),
        contentDescription = title,
        contentScale = ContentScale.Crop
    )
}