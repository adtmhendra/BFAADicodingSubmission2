package com.hendra.githubuser.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hendra.githubuser.model.ItemsItem
import com.hendra.githubuser.network.ApiConfig
import retrofit2.Call
import retrofit2.Response

class SearchViewModel : ViewModel() {

    val listUsers = MutableLiveData<ArrayList<ItemsItem>>()

    fun setUser(user: String) {
        val client = ApiConfig.getApiService().getUsers(user)

        client.enqueue(object : retrofit2.Callback<ItemsItem> {

            override fun onResponse(call: Call<ItemsItem>, response: Response<ItemsItem>) {
            }

            override fun onFailure(call: Call<ItemsItem>, t: Throwable) {
            }
        })
    }
}