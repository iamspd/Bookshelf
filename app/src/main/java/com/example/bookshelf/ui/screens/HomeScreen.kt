package com.example.bookshelf.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookshelf.R
import com.example.bookshelf.model.Book
import com.example.bookshelf.model.Books
import com.example.bookshelf.model.ImageLinks
import com.example.bookshelf.model.VolumeInfo
import com.example.bookshelf.ui.AppUiState
import com.example.bookshelf.ui.theme.BookShelfTheme

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    BookShelfTheme {
        val books = List(9) {
            Books(
                id = "$it",
                volumeInfo = VolumeInfo(title = "Abc", imageLinks = ImageLinks(imgSrc = ""))
            )
        }
        HomeContent(
            modifier = Modifier.fillMaxSize(),
            book = Book(books = books)
        )
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    appUiState: AppUiState,
    paddingValues: PaddingValues = PaddingValues(0.dp),
    retryAction: () -> Unit
) {
    when (appUiState) {
        is AppUiState.Loading -> {
            LoadingScreen(modifier = modifier.size(dimensionResource(R.dimen.loading_image_size)))
        }

        is AppUiState.Success -> {
            HomeContent(
                modifier = modifier,
                paddingValues = paddingValues,
                book = appUiState.book
            )
        }

        is AppUiState.Error -> {
            ErrorScreen(
                modifier = modifier,
                onRetryButtonClick = retryAction
            )
        }
    }

}

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier,
    onRetryButtonClick: () -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_connection_error),
            contentDescription = stringResource(R.string.connection_not_available_text),
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small)),
            text = stringResource(R.string.connection_not_available_text),
            style = MaterialTheme.typography.labelLarge
        )
        Button(
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small)),
            onClick = onRetryButtonClick
        ) {
            Text(text = stringResource(R.string.retry_button))
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading_image)
    )
}

@Composable
fun HomeContent(
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

            val imgUrl =
                book.volumeInfo.imageLinks?.imgSrc?.replace(oldValue = "http", newValue = "https")

            BookGridThumbnail(
                imageUrl = imgUrl,
                title = book.volumeInfo.title
            )
        }
    }
}

@Composable
fun BookGridThumbnail(
    imageUrl: String?,
    title: String
) {
    AsyncImage(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.book_thumbnail_height)),
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