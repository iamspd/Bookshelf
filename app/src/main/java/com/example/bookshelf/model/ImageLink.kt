package com.example.bookshelf.model

import com.squareup.moshi.Json

data class ImageLink(
    @field:Json(name = "thumbnail")
    val imgSrc: String
)
