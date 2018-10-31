package com.mendev.footballclub

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.AnkoContext

class ClubAdapter(var list : MutableList<Club>, var listener : (Club) -> Unit) : RecyclerView.Adapter<ClubAdapter.FootballViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FootballViewHolder {
        return FootballViewHolder(ClubItemUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: FootballViewHolder, position: Int) {
        holder.bindItem(list[position], listener)

    }

    inner class FootballViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(ClubItemUI.imageId)
        var textView: TextView = itemView.findViewById(ClubItemUI.nameId)

        fun bindItem(items: Club, listener: (Club) -> Unit) {
            textView.text = items.name
            items.image?.let {
                Picasso.get()
                        .load(it)
                        .into(imageView)
            }
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }
}
