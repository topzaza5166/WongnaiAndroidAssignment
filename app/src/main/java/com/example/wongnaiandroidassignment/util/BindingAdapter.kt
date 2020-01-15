package com.example.wongnaiandroidassignment.util

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

object BindingAdapter {

    @JvmStatic
    @Suppress("UNCHECKED_CAST")
    @BindingAdapter("data")
    fun <T> setRecyclerViewProperties(recycleListView: RecyclerView, items: T) {
        if (recycleListView.adapter is BindableAdapter<*>)
            (recycleListView.adapter as BindableAdapter<T>).setData(items)
    }

    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImage(view: ImageView, url: String?) {
        url?.let { GlideToVectorYou.justLoadImage(view.context.activity(), it.toUri(), view) }
    }

    @JvmStatic
    @BindingAdapter("addItemDecoration")
    fun addItemDecoration(recyclerView: RecyclerView, boolean: Boolean) {
        (recyclerView.layoutManager as? LinearLayoutManager)?.orientation?.let {
            recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, it))
        }
    }


}