package com.example.wongnaiandroidassignment.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.wongnaiandroidassignment.data.model.Coin
import com.example.wongnaiandroidassignment.data.network.Api
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ServiceRepository(private val api: Api) {

    private val compositeDisposable = CompositeDisposable()

//    fun getCoins(): LiveData<DataResponse> {
//        val data: MutableLiveData<DataResponse> = MutableLiveData()
//        val disposable = api.getCoins()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                data.postValue(it)
//            }, { t ->
//                t.printStackTrace()
//            })
//
//        compositeDisposable.add(disposable)
//        return data
//    }

    fun search(query: String, listener: () -> Unit): MutableLiveData<List<Coin>> {
        val data: MutableLiveData<List<Coin>> = MutableLiveData()
        val disposable = api.searchCoins(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                data.postValue(it.data.coins)
                listener.invoke()
            }, { t ->
                t.printStackTrace()
            })

        compositeDisposable.add(disposable)
        return data
    }

    fun clear() {
        compositeDisposable.clear()
    }
}