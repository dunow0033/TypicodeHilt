package com.example.typicodedi.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.typicodedi.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    todoRepository: TodoRepository
) : ViewModel() {

    val todos = todoRepository.getTodos().asLiveData(Dispatchers.IO)
}