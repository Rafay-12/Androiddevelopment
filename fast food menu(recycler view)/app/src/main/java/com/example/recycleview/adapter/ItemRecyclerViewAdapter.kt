package com.example.recycleview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.R
import com.example.recycleview.model.ItemModel

class ItemRecyclerViewAdapter(private val mList: List<ItemModel>) :
    RecyclerView.Adapter<ItemRecyclerViewAdapter.ViewHolder>(){

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = this.itemView.findViewById(R.id.imageView)
        val name: TextView = this.itemView.findViewById(R.id.name)
        val price: TextView = this.itemView.findViewById(R.id.price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemModel = mList[position]

        holder.imageView.setImageResource(itemModel.image)

        holder.name.text = itemModel.name
        holder.price.text = itemModel.price
    }

    override fun getItemCount(): Int {
       return mList.size
    }

}