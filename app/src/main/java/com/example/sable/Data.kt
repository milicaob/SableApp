package com.example.sable


data class Data(
    val results: List<Result>
)

data class Result(
    val images: List<Image>,
    val name: String,
    val snippet: String
)

data class Image(
    val source_url: String,
    val caption: String
)
