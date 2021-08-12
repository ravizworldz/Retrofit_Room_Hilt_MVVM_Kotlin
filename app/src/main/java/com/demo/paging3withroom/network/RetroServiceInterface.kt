package com.demo.paging3withroom.network

import com.demo.paging3withroom.model.RepositoriesList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroServiceInterface {

    @GET("repositories")
    fun getDataFromAPI(@Query("q")query: String): Call<RepositoriesList>
}