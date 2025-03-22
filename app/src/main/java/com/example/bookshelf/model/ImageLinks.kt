package com.example.bookshelf.model

import com.squareup.moshi.Json

data class ImageLinks(
    @field:Json(name = "thumbnail")
    val imgSrc: String
)
