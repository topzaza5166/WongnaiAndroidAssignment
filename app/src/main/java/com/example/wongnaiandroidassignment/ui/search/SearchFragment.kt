package com.example.wongnaiandroidassignment.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.wongnaiandroidassignment.databinding.FragmentListBinding
import com.example.wongnaiandroidassignment.databinding.FragmentSearchBinding
import com.example.wongnaiandroidassignment.ui.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {

    val KEY_QUERY = "key_query"

    val model: SearchViewModel by viewModel()

    lateinit var binding: FragmentSearchBinding

    companion object {
        fun newInstance(query: String) = SearchFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_QUERY, query)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initInstance()
    }

    private fun initInstance() {
        binding.viewModel = model

        binding.apply {
            recyclerView.adapter = SearchAdapter()
        }

        arguments?.getString(KEY_QUERY)?.let {
            model.query.value = it
        }
    }
}