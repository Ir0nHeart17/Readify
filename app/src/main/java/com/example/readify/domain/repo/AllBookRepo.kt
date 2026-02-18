package com.example.readify.domain.repo

import com.example.readify.common.BookCategoryModel
import com.example.readify.common.BookModel
import com.example.readify.common.ResultState
import kotlinx.coroutines.flow.Flow

interface AllBookRepo {
    fun getAllBooks(): Flow<ResultState<List<BookModel>>>
    fun getAllCategories(): Flow<ResultState<List<BookCategoryModel>>>
    fun getAllBooksByCategory(category: String): Flow<ResultState<List<BookModel>>>

}