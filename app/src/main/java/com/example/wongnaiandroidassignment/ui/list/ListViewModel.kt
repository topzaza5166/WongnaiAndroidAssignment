package com.example.wongnaiandroidassignment.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.wongnaiandroidassignment.data.datasource.CoinListDataSource
import com.example.wongnaiandroidassignment.data.model.Coin
import com.example.wongnaiandroidassignment.data.network.Api
import com.example.wongnaiandroidassignment.ui.Period
import io.reactivex.disposables.CompositeDisposable

class ListViewModel(private val api: Api) : ViewModel() {

    val loading: MutableLiveData<Boolean> = MutableLiveData(true)

    var coinList: LiveData<PagedList<Coin>>

    var coinListDataSource: CoinListDataSource? = null

    var compositeDisposable = CompositeDisposable()

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(10)
            .setInitialLoadSizeHint(20)
            .setEnablePlaceholders(false)
            .build()

        coinList = LivePagedListBuilder<Int, Coin>(object : DataSource.Factory<Int, Coin>() {
            override fun create(): DataSource<Int, Coin> {
                coinListDataSource =
                    CoinListDataSource(
                        api,
                        compositeDisposable
                    ) {
                        loading.value = false
                    }
                return coinListDataSource!!
            }
        }, config).build()
    }

    fun setPeriod(period: Period) {
        coinListDataSource?.period = period
        refresh()
    }

    fun refresh(callback: (() -> Unit)? = null) {
        coinListDataSource?.run {
            addInvalidatedCallback { callback?.invoke() }
            invalidate()
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}