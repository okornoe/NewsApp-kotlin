package com.t.newsapp_kotlin

import android.view.TextureView
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var author: TextView? = itemView.findViewById(R.id.tv_author_name)
    val title: TextView? = itemView.findViewById(R.id.tv_new_title)
    val description: TextView? = itemView.findViewById(R.id.tv_news_description)
    val publishedAt: TextView? = itemView.findViewById(R.id.tv_date_publication)
}
