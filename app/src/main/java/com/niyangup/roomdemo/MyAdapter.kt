package com.niyangup.roomdemo

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.niyangup.roomdemo.MyAdapter.*

class MyAdapter(val allWords: List<Word>) : RecyclerView.Adapter<MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflate = View.inflate(parent.context, R.layout.activity_main_rv_item_normal, null)
        return MyViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val word = allWords.get(position)
        holder.id.text = position.plus(1).toString()
        holder.title.text = word.word
        holder.subtitle.text = word.chineseMeaning

        holder.itemView.setOnClickListener {
            Toast.makeText(it.context, "this is $position", Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return allWords.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id: TextView = itemView.findViewById(R.id.tv_id)
        val title: TextView = itemView.findViewById(R.id.tv_title)
        val subtitle: TextView = itemView.findViewById(R.id.tv_subtitle)
    }
}