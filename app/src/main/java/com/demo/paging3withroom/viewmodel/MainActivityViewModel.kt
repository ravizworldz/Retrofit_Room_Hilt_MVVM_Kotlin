package com.demo.paging3withroom.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.demo.paging3withroom.model.RepositoryData
import com.demo.paging3withroom.network.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: RetroRepository)
    : ViewModel(){

    fun getAllRepositoryList(): LiveData<List<RepositoryData>> {
        return repository.getAllRecords()
    }

    fun makeApiCall() {
        repository.makeApiCall("ny")
    }
}