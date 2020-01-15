package com.example.wongnaiandroidassignment.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.wongnaiandroidassignment.data.model.Coin
import com.example.wongnaiandroidassignment.data.repository.ServiceRepository

class SearchViewModel(private val repo: ServiceRepository) : ViewModel() {

    val loading: MutableLiveData<Boolean> = MutableLiveData(true)

    val query: MutableLiveData<String> = MutableLiveData()

    val searchList: LiveData<List<Coin>> = Transformations.switchMap(query) {
        repo.search(it) {
            loading.value = false
        }
    }

    override fun onCleared() {
        super.onCleared()
        repo.clear()
    }
}