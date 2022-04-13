package com.example.pretice

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_one.*

class FragementOne:Fragment(){

    interface OnDataPassListener{
        fun onDataPass(data : String?)
    }

    lateinit var dataPasser: OnDataPassListener

    override fun onAttach(context: Context) {
        Log.d("life_cycle" ,"F onAttach")
        super.onAttach(context)
        dataPasser  = context as OnDataPassListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("life_cycle" ,"F onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
        val data = arguments?.getString("hello")
        Log.d("life_cycle" ,"F onCreateView")
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("life_cycle" ,"F onActivityCreated")
        val data = arguments?.getString("hello")
        Log.d("data", data.toString())
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("life_cycle" ,"F onViewCreated")
        super.onViewCreated(view, savedInstanceState)

        pass.setOnClickListener{
            dataPasser.onDataPass("Goodbye")
        }
    }

    override fun onStart() {
        Log.d("life_cycle" ,"F onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("life_cycle" ,"F onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("life_cycle" ,"F onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("life_cycle" ,"F onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("life_cycle" ,"F onDestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d("life_cycle" ,"F onDetach")
        super.onDetach()
    }

}