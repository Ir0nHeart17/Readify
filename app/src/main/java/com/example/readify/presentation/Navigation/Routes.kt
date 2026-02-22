package com.example.readify.presentation.Navigation

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    data object HomeScreen

    @Serializable
    data class BooksByCategory(val category: String)

    @Serializable
    data class ShowPdfScreen(val url: String)

}


