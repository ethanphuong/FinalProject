package com.example.cookingbythebook.recyclerviewpackage

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextClock
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cookingbythebook.R

class MyAdapter(private val myDataSet: ArrayList<String>, private val listener: OnItemClickListener): RecyclerView.Adapter<MyAdapter.ViewHolder>(){

    var lastPosition = -1
    var selectedPosition = -1

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        lateinit var textView: TextView

        init {
            view.setOnClickListener(this)
        }

        fun bind(text: String){
            textView = view.findViewById<TextView>(R.id.textView)
            textView.text = text
        }

        override fun onClick(view: View) {
            //if (mClickListener != null) mClickListener.onItemClick(view, adapterPosition)
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION){
                selectedPosition = position
                listener.onItemClick(selectedPosition)
                //notifyItemChanged(position)
                notifyDataSetChanged()
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vh = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row, parent, false)
        return ViewHolder(vh)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.bind(myDataSet[position])
        if(selectedPosition == position){
            if(selectedPosition == lastPosition){
                holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"))
                holder.textView.setTextColor(Color.parseColor("#c5c5c7"))
                lastPosition = -1
            }
            else {
                holder.itemView.setBackgroundColor(Color.parseColor("#b64c87"))
                holder.textView.setTextColor(Color.parseColor("#000000"))
                lastPosition = selectedPosition
            }
        }
        else{
            holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"))
            holder.textView.setTextColor(Color.parseColor("#c5c5c7"))
        }
    }

    override fun getItemCount(): Int {
        return myDataSet.size
    }
}