package com.example.baitap_31_03_2025

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var hoten: EditText = findViewById(R.id.hoten)
        var mssv: EditText = findViewById(R.id.mssv)
        var button_add = findViewById<Button>(R.id.button_add)
        val items = mutableListOf<Student>(
            Student("Nguyen Tuan Dat","20225278"),
            Student("Hoang Duc Khai","20225341"),
            Student("Ngo Trung Hieu","20225923")
        )

        val adapter = StudentAdapter(items)
        val listView = findViewById<ListView>(R.id.listview)
        listView.adapter = adapter

        button_add.setOnClickListener {
            var item1:String = hoten.text.toString()
            var item2:String = mssv.text.toString()
            items.addFirst(Student(item1,item2))
            val adapter = StudentAdapter(items)
            listView.adapter = adapter
        }


    }
}