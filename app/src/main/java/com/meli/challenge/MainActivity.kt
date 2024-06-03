package com.meli.challenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

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