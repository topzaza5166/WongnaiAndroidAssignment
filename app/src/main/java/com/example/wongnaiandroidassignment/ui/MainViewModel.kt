package com.example.wongnaiandroidassignment.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val period: MutableLiveData<Period> = MutableLiveData(Period.Day)

}