package com.t.newsapp_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter : RecyclerView.Adapter<NewsViewHolder>() {
    private val newsData = listOf<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflaterLayout = LayoutInflater.from(parent.context)

        val view = inflaterLayout.inflate(R.layout.news_item,parent,false) as View
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsData.size;
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = newsData[position]
        //holder.
        holder.author?.text   = item.author
        holder.title?.text  = item.title
        holder.description?.text  = item.description
        holder.publishedAt?.text = item.publishedAt
    }
}

