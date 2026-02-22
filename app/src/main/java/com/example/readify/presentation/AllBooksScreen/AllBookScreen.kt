package com.example.readify.presentation.AllBooksScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.readify.presentation.Effect.AnimateShimmer
import com.example.readify.presentation.UiComponents.BookCart
import com.example.readify.presentation.ViewModel

@Composable
fun AllBookScreen(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: ViewModel = hiltViewModel()
) {

    LaunchedEffect(Unit) {

        viewModel.BringAllBooks()
    }

    val res = viewModel.state.value

    when {
        res.isLoading -> {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(10) {
                        AnimateShimmer()

                    }
                }
            }
        }

        res.error.isNotEmpty() -> {
            Text(text = res.error, modifier = modifier)
        }

        res.item.isNotEmpty() -> {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(res.item){
                        BookCart(
                            imageUrl = it.image,
                            title = it.bookname,
                            author = it.bookAuthor,
                            description = it.bookDescription,
                            navHostController = navHostController,
                            bookUrl = it.bookUrl
                        )
                    }
                }
            }
        }else -> Text(text = "No Books Available", modifier = Modifier.size(200.dp).padding(8.dp))
    }

}