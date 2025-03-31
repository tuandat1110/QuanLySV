package com.example.baitap_31_03_2025

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import java.util.zip.Inflater

class StudentAdapter(val studentLists: MutableList<Student>): BaseAdapter() {
    override fun getCount(): Int = studentLists.size

    override fun getItem(position: Int) = studentLists[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        var itView:View
        var viewHolder: ViewHolder

        if(convertView == null){
            itView = LayoutInflater.from(parent?.context).inflate(R.layout.student_view,parent,false)
            viewHolder = ViewHolder()
            viewHolder.HoTen = itView.findViewById(R.id.hoten)
            viewHolder.MSSV = itView.findViewById(R.id.mssv)
            viewHolder.button = itView.findViewById(R.id.button_remove)
            itView.tag = viewHolder
        }
        else{
            itView = convertView
            viewHolder = itView.tag as ViewHolder
        }

        viewHolder.HoTen.setText(studentLists[position].HoTen)
        viewHolder.MSSV.setText(studentLists[position].MSSV)
        viewHolder.button.setOnClickListener {
            studentLists.removeAt(position)
            notifyDataSetChanged()
        }

        return itView
    }

    class ViewHolder{
        lateinit var HoTen: TextView
        lateinit var MSSV: TextView
        lateinit var button: Button
    }
}