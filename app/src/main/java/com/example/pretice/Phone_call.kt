package com.example.pretice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class Phone_call : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_call)

        val phonebook = createFakePhoneBook(30)
        createPhoneBookList(phonebook)
    }

    fun createFakePhoneBook(faskeNember: Int = 10, phoneBook: PhoneBook = PhoneBook()): PhoneBook {
        for (i in 0 until faskeNember) {
            phoneBook.addPerson(
                Person(
                    name = ""+i+"번쨰 사람",
                    number = "" + i + "번째 사람의 전화번호"
                )

            )
        }
        return phoneBook
    }
    fun createPhoneBookList(phoneBook: PhoneBook){

//        val layoutInflater = LayoutInflater.from(this@Phone_call)
//        val container = findViewById<LinearLayout>(R.id.phonebook_list_container)
//        for (i in 0 until PhoneBook.personList.size){
//            val view = layoutInflater.inflate(R.id.phonebook_item,)
//            val personName = view.findviewById<TextView>(R.id.person_name)
//            personNameView.setText(phoneBook.personList.get(i))
//            container.addView(view)
//        }
    }
    fun addSetOnClickListener(person: Person, view: View){
        view.setOnClickListener{
//            val intent = Intent(this@Phone_call, PhoneBookDetailActivity::class.java)
//            intent.putExtra("name", person.name)
//            intent.putExtra("number", person.number)
//            startActivity(intent)
        }
    }
}
    class PhoneBook(){
        val personList = ArrayList<Person>()

        fun addPerson(person: Person){
            personList.add(person)
        }
    }
    class Person(val name: String, val number: String){

    }
