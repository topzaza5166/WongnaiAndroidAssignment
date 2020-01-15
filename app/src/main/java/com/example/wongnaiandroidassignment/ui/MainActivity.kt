package com.example.wongnaiandroidassignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import com.example.wongnaiandroidassignment.R
import com.example.wongnaiandroidassignment.ui.list.ListFragment
import com.example.wongnaiandroidassignment.ui.search.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val model: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction()
                .add(R.id.contentContainer, ListFragment.newInstance())
                .commit()

        initInstances()
    }

    private fun initInstances() {
        radioGroup.setOnCheckedChangeListener { _, id ->
            when (id) {
                R.id.period_day -> model.period.value = Period.Day
                R.id.period_week -> model.period.value = Period.Week
                R.id.period_month -> model.period.value = Period.Month
            }
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return if (!query.isNullOrBlank()) {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.contentContainer2, SearchFragment.newInstance(query))
                        .addToBackStack(null)
                        .commit()
                    true
                } else false
            }

            override fun onQueryTextChange(newText: String?): Boolean = false
        })
    }
}
