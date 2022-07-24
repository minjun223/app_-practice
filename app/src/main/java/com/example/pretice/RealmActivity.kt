package com.example.pretice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_realm.*

class RealmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)

        Real.init(this@RealmActivity)
        val config: RealmConfiguration = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)
        val realm = Realm.getDefaultInstance()


        button_delete.setOnClickListener{
            realm.executeTransaction{
                it.where(School::class.java).findAll().deleteAllFromRealm()
                it.where(School::class.java).findFirst().deleteFromRealm()
            }
        }
        button_load.setOnClickListener {
            realm.executeTransaction{
                Log.d("detaa", "data : " + data)
                val data = it.where(School::class.java).findFirst()
            }
        }
        button_save.setOnClickListener {
            realm.executeTransaction{
                with(it.createObject(School::class.java)){
                    this.name = "어떤 대학교"
                    this.location = "서울"
                }
            }
        }
    }
}