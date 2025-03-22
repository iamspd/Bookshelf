package com.example.bookshelf.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookshelf.R
import com.example.bookshelf.ui.screens.HomeScreen

@Composable
fun BookShelfApp() {

    Scaffold(topBar = { BookshelfAppTopBar() }) { innerPadding ->

        val viewModel: BookshelfViewModel = viewModel(factory = BookshelfViewModel.Factory)
        HomeScreen(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = dimensionResource(R.dimen.padding_medium),
                    start = dimensionResource(R.dimen.padding_medium),
                    end = dimensionResource(R.dimen.padding_medium)
                ),
            paddingValues = innerPadding,
            appUiState = viewModel.appUiState,
            retryAction = viewModel::getBooksFromRepository
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookshelfAppTopBar() {
    CenterAlignedTopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = dimensionResource(R.dimen.padding_medium)),
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.titleLarge
            )
        }
    )
}