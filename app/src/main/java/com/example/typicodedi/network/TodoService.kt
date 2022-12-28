package com.example.typicodedi.network

import com.example.typicodedi.model.Todo
import retrofit2.Response
import retrofit2.http.GET

interface TodoService {

    @GET("/todos")
    suspend fun getTodos(): Response<List<Todo>>
}