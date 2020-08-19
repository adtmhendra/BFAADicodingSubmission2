package com.hendra.githubuser.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hendra.githubuser.MainActivity
import com.hendra.githubuser.model.ItemsItem
import com.hendra.githubuser.model.ResponseUser
import com.hendra.githubuser.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class SearchViewModel : ViewModel() {

    val listUsers = MutableLiveData<ItemsItem>()

    fun setUser(user: String) {
        val client = ApiConfig.getApiService().getUsers(user)

        client.enqueue(object : Callback<ResponseUser> {

            override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>) {
                val dataArray = response.body()?.data as List<ItemsItem?>
                Log.d(MainActivity.TAG, dataArray.toString())
                try {
                    for (data in dataArray) {
                        listUsers.postValue(data)
                    }
                } catch (e: Exception) {
                    Log.d(MainActivity.TAG, "Gagal @onResponse...")
                }
            }

            override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                Log.d(MainActivity.TAG, t.message.toString())
            }

        })
    }

    fun getUser(): LiveData<ItemsItem> {
        return listUsers
    }

}