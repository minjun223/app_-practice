package com.example.pretice

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.Log

class Fragment1 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?): View? {
        Log.d("life_cycle", "F onCreateView")

        return inflater.inflate(R.layout.fragment_one, container, false)
    }
}