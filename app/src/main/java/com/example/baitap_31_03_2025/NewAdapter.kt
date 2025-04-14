package com.example.baitap_31_03_2025

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewAdapter(private val items: MutableList<Student>) : RecyclerView.Adapter<NewAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.student_view, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val student = items[position]
        holder.bind(student)

        holder.button.setOnClickListener {
            val pos = holder.adapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                items.removeAt(pos)
                notifyItemRemoved(pos)
            }
        }
    }

    override fun getItemCount(): Int = items.size

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.hoten)
        val mssv: TextView = itemView.findViewById(R.id.mssv)
        val button: Button = itemView.findViewById(R.id.button_remove)

        fun bind(student: Student) {
            name.text = student.HoTen
            mssv.text = student.MSSV
        }
    }
}
