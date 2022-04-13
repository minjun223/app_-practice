package com.example.pretice

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_resourse.*

class Resourse : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resourse)

        //val ment = resources.getString(R.string.hello)
       // val d = Log.d("mentt", "ment : " + ment)

        val color = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            getColor(androidx.constraintlayout.widget.R.color.bright_foreground_inverse_material_light)
        }
        else{

            button.setBackgroundColor(getColor(R.color.teal_200))
        }

        button.setBackgroundColor(resources.getColor(R.color.teal_700))
    }
}