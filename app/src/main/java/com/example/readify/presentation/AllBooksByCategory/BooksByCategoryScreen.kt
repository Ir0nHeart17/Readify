package com.example.readify.presentation.AllBooksByCategory

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.readify.presentation.Effect.AnimateShimmer
import com.example.readify.presentation.UiComponents.BookCart
import com.example.readify.presentation.ViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BooksByCategoryScreen(
    category: String,
    navHostController: NavHostController,
    viewModel: ViewModel = hiltViewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.BringAllBookByCategories(category)
    }

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text(text = category) },
                navigationIcon = {
                    IconButton(
                        onClick = { navHostController.popBackStack() }
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerpadding ->

        val res = viewModel.state.value
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerpadding)
        ) {
            when {
                res.isLoading -> {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        LazyColumn {
                            items(10) {
                                AnimateShimmer()
                            }
                        }
                    }
                }

                res.error.isNotEmpty() -> {
                    Text(
                        text = res.error, modifier = Modifier
                            .size(200.dp)
                            .padding(8.dp)
                    )
                }

                res.item.isNotEmpty() -> {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            items(res.item) {
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
                }

                else -> {
                    Text(
                        text = "No Books Available",
                        modifier = Modifier.size(200.dp)
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}