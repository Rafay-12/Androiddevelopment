package com.example.destination.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.destination.R
import com.example.destination.data.model.Destination

class RecyclerViewAdapter(private val mList: List<Destination>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val name: TextView = this.itemView.findViewById(R.id.name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.destination_list, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val destination = mList[position]

        holder.name.text = destination.name

    }

    override fun getItemCount(): Int {
        return mList.size
    }

}