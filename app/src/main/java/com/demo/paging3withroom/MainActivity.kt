package com.demo.paging3withroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.paging3withroom.adapter.RecyclerViewAdapter
import com.demo.paging3withroom.model.RepositoryData
import com.demo.paging3withroom.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
        initMainViewModel()
    }

    private fun initViewModel() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)

            val decoration  =  DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            recyclerViewAdapter = RecyclerViewAdapter()
            adapter =recyclerViewAdapter
        }
    }

    private fun initMainViewModel() {
        val viewModel  = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getAllRepositoryList().observe(this, Observer<List<RepositoryData>>{
            recyclerViewAdapter.setListData(it)
            recyclerViewAdapter.notifyDataSetChanged()
        })


        viewModel.makeApiCall()
    }
}