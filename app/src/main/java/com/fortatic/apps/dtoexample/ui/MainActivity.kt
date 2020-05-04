package com.fortatic.apps.dtoexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.fortatic.apps.dtoexample.R
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.coments.observe(this, Observer {
            Timber.d("Comments size: ${it.size}")
        })

        viewModel.posts.observe(this, Observer {
            Timber.d("Posts size: ${it.size}")
        })
    }
}
