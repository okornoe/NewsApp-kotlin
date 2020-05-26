package com.t.newsapp_kotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter : RecyclerView.Adapter<NewsViewHolder>() {
    val listNames = listOf<String>("Kelvin", "Okornoe", "Joseph", "Anthony")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflaterLayout = LayoutInflater.from(parent.context)
        val view = inflaterLayout.inflate(R.layout.news_item,parent,false) as TextView
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listNames.size;
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = listNames[position]
        holder.textView.text = item
    }
}