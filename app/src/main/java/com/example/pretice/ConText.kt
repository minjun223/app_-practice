package com.example.pretice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ConText : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_con_text)

        val context : ConText = this
        val applicationConText : ConText = applicationContext as ConText

        // activity보다 application이 더 많은 정보를 가지고 있다. application안에 activity


    }
}