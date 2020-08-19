package com.hendra.githubuser.network

import com.hendra.githubuser.model.ItemsItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search/users?q={username}")
    fun getUsers(@Query("login") login: String?): Call<ItemsItem>
}