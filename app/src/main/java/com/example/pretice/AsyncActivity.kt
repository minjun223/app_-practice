package com.example.pretice

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_async.*
import java.lang.Exception

class AsyncActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

        var task: BackgroundAsyncTask? = null
        start.setOnClickListener{
            task = BackgroundAsyncTask(progressbar, ment)
            task1 = BackgroundAsyncTask(progressbar, ment)
            task?.execute()
            task1?.execute()
        }

        stop.setOnClickListener{
//            task?.cancel(true)
            startActivity(Intent(this, intent2::class.java))
        }
    }

    override fun onPause() {
        task?.cancel(true)
        super.onPause()
    }
}

class BackgroundAsyncTask(
    val progressbar: ProgressBar,
    val progressText: TextView
): AsyncTask<Int, Int, Int>(){

    var precent: Int = 0
    override fun onPreExecute() {
        percent = 0
        progressbar.progress = percent

    }
    override fun doIntBackground(vararg params: Int?): Int{
        while(isCancelled() == false){
            percent++
            Log.d("async", "value : " + percent)
            if(percent > 100){
                break
            }else{
                publishProgress(percent)
            }
            try{
                Thread.sleep(100)
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
        return percent
    }
    override fun onProgressUpdate(vararg values: Int?){
        progressbar.setProgress(values[0] ?: 0)
        progressText.setText("퍼센트 : " + values[0])
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: Int?) {
        progressText.setText("작업이 완료되었습니다.")
    }

    override fun onCancelled() {
        progressbar.setProgress(0)
        progressText.setText("작업이 취소되었습니다.")
    }
}