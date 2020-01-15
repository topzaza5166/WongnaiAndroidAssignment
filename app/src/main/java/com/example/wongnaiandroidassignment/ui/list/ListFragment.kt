package com.example.wongnaiandroidassignment.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wongnaiandroidassignment.databinding.FragmentListBinding
import com.example.wongnaiandroidassignment.ui.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class ListFragment : Fragment() {

    val model: ListViewModel by viewModel()

    val sharedModel: MainViewModel by sharedViewModel()

    lateinit var binding: FragmentListBinding

    companion object {
        fun newInstance() = ListFragment().apply {
            arguments = Bundle()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
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
            recyclerView.adapter = ListAdapter()

            swipeRefreshLayout.setOnRefreshListener {
                model.refresh {
                    swipeRefreshLayout.isRefreshing = false
                }
            }
        }

        sharedModel.period.observe(viewLifecycleOwner, Observer {
            model.setPeriod(it)
        })
    }
}