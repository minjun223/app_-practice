package com.example.pretice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class NullSafety : AppCompatActivity() {

    lateinit var lateNumber: caz

    class caz(var number: Int){

    }
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_null_safety)

        val number : Int = 10
        val number1 : Int? = 20

        val number3 = number1?.plus(number)

        Log.d("number", "number3 : "+ number3)
        val number4 = number1 ?: 10
        Log.d("number", "number4 : "+ number4)


        Log.d("number", "late number : "+ lateNumber)
    }
    fun plus(a: Int, b:Int?): Int {
        if (b != null) return a + b
        else return a
    }

    fun plus2(a: Int, b: Int?): Int?{
        return b?.plus(a)
    }
}