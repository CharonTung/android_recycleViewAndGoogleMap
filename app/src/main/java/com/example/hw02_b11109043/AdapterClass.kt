// AdapterClass.kt
package com.example.hw02_b11109043

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterClass(
    private val dataList: ArrayList<DataClass>,
    private val onItemClick: (DataClass) -> Unit
) : RecyclerView.Adapter<AdapterClass.ViewHolderClass>() {

    class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var rvImage: ImageView = itemView.findViewById(R.id.image)
        val rvTitle: TextView = itemView.findViewById(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.rvImage.setImageResource(currentItem.dataImage)
        holder.rvTitle.text = currentItem.dataTitle
        holder.itemView.setOnClickListener {
            onItemClick(currentItem)
        }
    }
}
