package com.example.bookshelf.model

import com.squareup.moshi.Json

data class Book(
    @field:Json(name = "items")
    val books: List<Books>
)
