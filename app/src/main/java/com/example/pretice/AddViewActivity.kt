package com.example.pretice

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout

class AddViewActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_view)

        val carList = ArrayList<CarForList>()
        for (i in 0 until 10){
            carList.add(CarForList(""+ i + "번째 자동차", ""+ i+"순위 엔진"))
        }
        val container = findViewById<LinearLayout>(R.id.addview_container)
        val inflater = LayoutInflater.from(this@AddViewActivity)
            for(i in 0 until carList.size){
                val itemView = inflater.inflate(R.layout.item_view, null)
//                val carNameView = itemView.findViewById<TextView>(R.id.car_name)
//                val carEngineView = itemView.findViewById<TextView>(R.id.car_engine)
            }
    }


    class CarForList(val name: String, val engine: String){

    }
}