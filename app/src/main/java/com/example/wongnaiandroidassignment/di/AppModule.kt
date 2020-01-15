package com.example.wongnaiandroidassignment.di

import com.example.wongnaiandroidassignment.data.repository.ServiceRepository
import com.example.wongnaiandroidassignment.ui.list.ListViewModel
import com.example.wongnaiandroidassignment.ui.MainViewModel
import com.example.wongnaiandroidassignment.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    factory { ServiceRepository(get()) }

    viewModel { MainViewModel() }

    viewModel { ListViewModel(get()) }

    viewModel { SearchViewModel(get()) }
}
