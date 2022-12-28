package com.example.typicodedi.repository

import com.example.typicodedi.model.Todo
import com.example.typicodedi.utils.Resource

import com.example.typicodedi.network.TodoService
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@Singleton
class TodoRepository @Inject constructor(
    private val todoService: TodoService
) {

    fun getTodos() : Flow<Resource<List<Todo>>> = flow {
        val response = todoService.getTodos()

        val resource = try {
            if (response.isSuccessful && response.body() != null) {
                Resource.Success(response.body()!!)
            } else {
                Resource.Error("Failed to load shibes")
            }
        } catch( ex: Exception) {
            Resource.Error(ex.toString())
        }
        emit(resource)
    }
}