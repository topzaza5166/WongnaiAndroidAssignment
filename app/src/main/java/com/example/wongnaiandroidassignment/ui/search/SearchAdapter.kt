package com.example.wongnaiandroidassignment.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.wongnaiandroidassignment.data.model.Coin
import com.example.wongnaiandroidassignment.databinding.ListCoin2Binding
import com.example.wongnaiandroidassignment.databinding.ListCoinBinding
import com.example.wongnaiandroidassignment.util.BindableAdapter

class SearchAdapter : ListAdapter<Coin,SearchAdapter.ViewHolder>(PostDiffCallback()), BindableAdapter<List<Coin>> {

    private val NormalType = 1

    private val SpecialType = 2

    class PostDiffCallback : DiffUtil.ItemCallback<Coin>() {
        override fun areItemsTheSame(oldItem: Coin, newItem: Coin): Boolean {
            return oldItem.uuid == newItem.uuid
        }

        override fun areContentsTheSame(oldItem: Coin, newItem: Coin): Boolean {
            return oldItem == newItem
        }
    }

    override fun setData(data: List<Coin>?) {
        data?.let { submitList(it) }
    }

    override fun getItemViewType(position: Int): Int {
        return if ((position + 1) % 5 == 0) SpecialType else NormalType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        if (viewType == SpecialType)
            ViewHolder(ListCoin2Binding.inflate(LayoutInflater.from(parent.context), parent, false))
        else
            ViewHolder(ListCoinBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var binding: ListCoinBinding? = null

        private var binding2: ListCoin2Binding? = null

        constructor(binding: ListCoinBinding) : this(binding.root) {
            this.binding = binding
        }

        constructor(binding: ListCoin2Binding) : this(binding.root) {
            this.binding2 = binding
        }

        fun bind(coin: Coin) {
            binding?.coin = coin
            binding2?.coin = coin
        }
    }
}
