package com.example.typicodedi.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.typicodedi.adapter.TodosAdapter
import com.example.typicodedi.databinding.FragmentTodosBinding
import com.example.typicodedi.ui.viewmodel.TodoViewModel
import com.example.typicodedi.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodosFragment : Fragment() {

    private var _binding: FragmentTodosBinding? = null
    private val binding: FragmentTodosBinding get() = _binding!!
    private val viewModel : TodoViewModel by viewModels()
    private lateinit var adapter: TodosAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentTodosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = TodosAdapter()

        binding.rvTodos.apply {
            adapter = this@TodosFragment.adapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel.todos.observe(viewLifecycleOwner) { resource ->
            when(resource) {
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    adapter.loadTodos(resource.data)
                }
                is Resource.Error -> {

                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private val TAG = TodosFragment::class.java.name
    }
}