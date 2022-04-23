package com.example.pretice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val carList = ArrayList<AddViewActivity.CarForList>()
        for (i in 0 until 10){
            carList.add(AddViewActivity.CarForList(""+ i + " 번 째",   "" + i + "순위 엔진"))
        }
        val adepter = ListViewAdapter(carList, LayoutInflater.from(this@ListViewActivity))
        //listView.adepter = adapter
        listView.setOnItemClickListener{ parent, view, position, id ->
            val carName = (adepter.getItem(position) as AddViewActivity.CarForList).name
            val carEngine = (adepter.getItem(position) as AddViewActivity.CarForList).engine

            Toast.makeText(this@ListViewActivity, carName + " " + carEngine, Toast.LENGTH_SHORT).show()
        }
    }

}

class ListViewAdapter(
    val carForList: ArrayList<AddViewActivity.CarForList>,
    val context: LayoutInflater

) : BaseAdapter() {
    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {

        val view : View
        val holder : RecyclerView.ViewHolder

       /* if(convertView = null){
            view =  layoutInflater.inflate(R.layout.item_view, null)
        }*/
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    override fun getItem(position: Int): Any {
        return carForList.get(position)
    }
    override fun getCount(): Int {
        return carForList.size
    }
}

class ViewHelder{
    var carName: TextView? = null
    var carEngine : TextView? = null
}
