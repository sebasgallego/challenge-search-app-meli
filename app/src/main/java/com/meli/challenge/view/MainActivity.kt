package com.meli.challenge.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.meli.challenge.R
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupTimberLog()
    }

    private fun setupTimberLog() {
        Timber.plant(Timber.DebugTree())
    }
}