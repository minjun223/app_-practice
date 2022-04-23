package com.example.pretice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        val carList = ArrayList<AddViewActivity.CarForList>()
        for (i in 0 until 50) {
            carList.add(AddViewActivity.CarForList("" + i + " 번째 자동차", "" + i + "순위 엔진"))
        }
        val adepter = RecyclerViewAdepter(carList, LayoutInflater.from(this@RecyclerViewActivity))
        recycler_view.adapter = adepter
//        recycler_view.layoutManager = LinearLayoutManager(this@RecycleView)
        recycler_view.layoutManager = GridLayoutManager(this@RecyclerViewActivity)
    }

}
class RecyclerViewAdepter(
    val itemList : ArrayList<AddViewActivity.CarForList>,
    val inflater : LayoutInflater
): RecyclerViewAccessibilityDelegate.Adepter<RecyclerViewAdepter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerViewActivity.ViewHolder(itemView) {
        val carName: TextView
        val carEngine: TextView

        init {
            carName = itemView.findViewById(R.id.car_name)
            carEngine = itemView.findViewById(R.id.car_engine)
            val adepterPosition: Int = adapterPosition
            val engineName = itemList.get(position).engine
            Log.d("engine", engineName)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val view = inflater.inflate(R.layout.item_view, parent, attachToRoot:false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int{
        return itemList.size

    }
    override  fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.carName.setText(itemList.get(position).name)
        holder.carEngine.setText(itemList.get(position).engine)
    }



}