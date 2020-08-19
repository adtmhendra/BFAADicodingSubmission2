package com.hendra.githubuser.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hendra.githubuser.R

class DetailActivity : AppCompatActivity() {

    companion object {
        val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
}