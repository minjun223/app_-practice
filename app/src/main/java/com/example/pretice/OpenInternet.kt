package com.example.pretice

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import kotlinx.android.synthetic.main.activity_open_internet.*

class OpenInternet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_internet)


        address_edit_text

        open.setOnClickListener{
            val address = address_edit_text.text.toString()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(address))
            startActivity(intent)
        }

        address_edit_text.addTextChangedListener(object : TextWatcher{
            val s = null
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("edit","beforeTextChanged : " + s)
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("edit","onTextChanged : " + s)
            }

            override fun afterTextChanged(p0: Editable?) {

                if(s.toString() == "abc") {
                    Log.d("edit", "text is abc")
                }

                Log.d("edit", "afterTextChanged : " + s)
            }

        })
    }
}