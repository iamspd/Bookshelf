package com.example.bookshelf.fake

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.Books
import com.example.bookshelf.model.ImageLinks
import com.example.bookshelf.model.VolumeInfo

object FakeDataSource {

    private val books = listOf(
        Books(
            id = "01",
            volumeInfo = VolumeInfo(
                title = "title1",
                imageLinks = ImageLinks(
                    imgSrc = "img1"
                )
            )
        ),
        Books(
            id = "02",
            volumeInfo = VolumeInfo(
                title = "title2",
                imageLinks = ImageLinks(
                    imgSrc = "img2"
                )
            )
        )
    )

    val book: Book by lazy {
        Book(books = books)
    }
}