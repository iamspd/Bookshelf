package com.example.bookshelf.fake

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.ImageLinks
import com.example.bookshelf.model.Item
import com.example.bookshelf.model.SearchResult
import com.example.bookshelf.model.VolumeInfo

object FakeDataSource {

    private val items = listOf(
        Item(
            id = "01",
            selfLink = "link1"
        )
    )

    val searchResult: SearchResult by lazy {
        SearchResult(items = items)
    }

    val book = Book(
        id = "01",
        volumeInfo = VolumeInfo(
            title = "title1",
            imageLinks = ImageLinks(
                imgSrc = "img1"
            )
        )
    )
}