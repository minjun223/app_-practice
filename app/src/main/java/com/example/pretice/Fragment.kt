package com.example.pretice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_fragment.*

open class Fragment : AppCompatActivity(), FragementOne. OnDataPassListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d("life_cycle" ,"onCreate")

        val fragmentOne: FragementOne = FragementOne()
        val bundle :Bundle = Bundle()
        bundle.putString("hello", "hello")
        fragmentOne.arguments =bundle

        button1.setOnClickListener{
            val fragmentOne : FragementOne = FragementOne()
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container,fragmentOne)
            fragmentTransaction.commit()
        }
        button2.setOnClickListener{
            val fragmentOne: FragementOne = FragementOne()
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.detach(fragmentOne)
            fragmentTransaction.commit()

        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("life_cycle" ,"onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.d("life_cycle" ,"onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d("life_cycle" ,"onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d("life_cycle" ,"onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle" ,"onDestroy")
    }

    override fun onDataPass(data: String?) {
        Log.d("pass" ,"" + data)
    }

    open fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        TODO("Not yet implemented")
    }
}