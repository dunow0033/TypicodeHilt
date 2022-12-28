package com.example.typicodedi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.typicodedi.databinding.ItemTodoBinding
import com.example.typicodedi.model.Todo

class TodosAdapter : RecyclerView.Adapter<TodosAdapter.TodoViewHolder>() {

    private val todos = mutableListOf<Todo>()

//    private val diffCallback = object : DiffUtil.ItemCallback<Todo>() {
//        override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
//            return oldItem.id == newItem.id
//        }
//        override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
//            return oldItem == newItem
//        }
//    }
//
//    val differ = AsyncListDiffer(this, diffCallback)
//
//    var todos: List<Todo>
//        get() = differ.currentList
//        set(value) { differ.submitList(value) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodosAdapter.TodoViewHolder {
        return TodoViewHolder(
            ItemTodoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TodosAdapter.TodoViewHolder, position: Int) {
        holder.binding.apply {
            val todo = todos[position]
            tvTitle.text = todo.title
            cbDone.isChecked = todo.completed
        }
    }

    override fun getItemCount() = todos.size

    fun loadTodos(listOfTodos: List<Todo>){
        todos.clear()
        todos.addAll(listOfTodos)
        notifyDataSetChanged()
    }

    inner class TodoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)
}