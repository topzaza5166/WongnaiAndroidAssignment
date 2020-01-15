package com.example.wongnaiandroidassignment.data.datasource

import androidx.paging.PageKeyedDataSource
import com.example.wongnaiandroidassignment.data.model.Coin
import com.example.wongnaiandroidassignment.data.network.Api
import com.example.wongnaiandroidassignment.ui.Period
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CoinListDataSource(
    private val api: Api,
    private val compositeDisposable: CompositeDisposable,
    private val onInitCompleteListener: () -> Unit
) : PageKeyedDataSource<Int, Coin>() {

    var period: Period =
        Period.Day

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Coin>
    ) {
        val dispose = api.getCoins(period = period.code)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                callback.onResult(it.data.coins, null, 1)
                onInitCompleteListener.invoke()
            }, { t ->
                t.printStackTrace()
            })

        compositeDisposable.add(dispose)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Coin>) {
        val dispose = api.getCoins(offset = params.key.toString(), period = period.code)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                callback.onResult(it.data.coins, params.key + 1)
            }, { t ->
                t.printStackTrace()
            })

        compositeDisposable.add(dispose)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Coin>) {

    }


}