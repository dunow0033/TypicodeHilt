package com.example.typicodedi.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Todo(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)