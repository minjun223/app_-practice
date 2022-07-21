package com.example.pretice

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_resourse.*
import kotlinx.android.synthetic.main.activity_shared_preference.*

class SharedPreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
        /*val editor = SharedPreference.Editor = sharedPreference.edit()
        editor.putString("hello", "안녕하세요")
        editor.commit()*/

        save_btn.setOnClickListener{
            val editor: SharedPreferences.Editor = sharedPreference.edit()
            editor.putString("hello", "안녕하세요")
            editor.putString("goodbye", "안녕하가세요")
            editor.commit()
        }



        load_button.setOnClickListener{
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val value1 = sharedPreference.getString("hello", "데이터 없음1")
            val value2 = sharedPreference.getString("goodbye", "데이터 없음2")

            Log.d("key-value", "Value: " + value1)
            Log.d("key-value", "Value: " + value2)
        }
        delete_btn.setOnClickListener{
            val  sharedPreference =  getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor  = sharedPreference.edit()
            editor.remove("hello")
            editor.commit()
        }
        delete_all_btn.setOnClickListener{
            val  sharedPreference =  getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor  = sharedPreference.edit()
            editor.clear()
            editor.commit()
        }
    }
}