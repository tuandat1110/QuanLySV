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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val hoten: EditText = findViewById(R.id.hoten)
        val mssv: EditText = findViewById(R.id.mssv)
        val buttonAdd = findViewById<Button>(R.id.button_add)

        val items = mutableListOf(
            Student("Nguyen Tuan Dat", "20225278"),
            Student("Hoang Duc Khai", "20225341"),
            Student("Ngo Trung Hieu", "20225923")
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recycle_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = NewAdapter(items)
        recyclerView.adapter = adapter

        buttonAdd.setOnClickListener {
            val name = hoten.text.toString()
            val id = mssv.text.toString()
            if (name.isNotEmpty() && id.isNotEmpty()) {
                items.add(0, Student(name, id)) // thêm vào đầu danh sách
                adapter.notifyItemInserted(0)
                recyclerView.scrollToPosition(0)
                hoten.text.clear()
                mssv.text.clear()
            }
        }


    }
}