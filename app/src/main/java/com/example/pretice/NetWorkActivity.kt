package com.example.pretice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_net_work.*
import org.chromium.base.task.AsyncTask
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class NetWorkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_net_work)

        NetworkTask(
            recycer_person,
            LayoutInflater.from(this@NetWorkActivity)
        ).execute()
    }
}
class NetworkTask(
    val recyclearView: RecyclerView,
    val inflater: LayoutInflater,
    val context: ConText
) : AsyncTask<Any?, Any?, Array<PersonFromServer>>(){
    override fun onPostExecute(result: Any?){
        val adapter = PersonAdapter(result!!, inflater)
        recyclearView.adapter = adapter
        recyclearView.layoutManager = LinearLayoutManager(context)
        super.onPostExecute(result)
    }
    override fun doInBackground(vararg params: Any?): Any?{
        val urlString: String = "http://mellowcode.org/json.students/"
        val url: URL=URL(urlString)
        val connection: HttpsURLConnection = url.openConnection() as HttpsURLConnection

        connection.requestMethod="GET"
        connection.setRequestProperty("Content-Type", "application/json")

        if(connection.responseCode == HttpsURLConnection.HTTP_OK){

            Log.d("connn", "inputstream : " + connection.inputStream)

            val reader = BufferedReader(
                InputStreamReader(
                    connection.inputStream,
                    "UTF-8"
                )
            )
            buffer = reader.readLine()
            Log.d("connn", "inputstream : " + buffer)

        }
        val data = Gson().fromJson(buffer, Array<PersonFromServer>::class.Java)


        return data
    }
}
class PersonAdapter(
    val personList : Array<PersonFromServer>,
    val inflater: LayoutInflater
): RecyclerView.Adapter<>(){

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val name : TextView
        val age : TextView
        val intro : TextView

        init{
            name = itemView.findViewById(R.id.person_name)
            age = itemView.findViewById(R.id.person_age)
            intro = itemView.findViewById(R.id.person_intro)
        }
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: ???, position: Int) {
        val view = inflater.inflate(R.layout.person_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.setText(personList.get(position).name ?: "")
        holder.age.setText(personList.get(position).age.toString())
        holder.intro.setText(personList.get(position).intro ?: "")
    }
}