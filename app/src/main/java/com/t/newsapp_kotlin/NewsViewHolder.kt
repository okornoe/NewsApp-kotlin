package com.t.newsapp_kotlin

import androidx.recyclerview.widget.RecyclerView
import com.t.newsapp_kotlin.databinding.NewsItemBinding

class NewsViewHolder(private var binding: NewsItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(articles: List<Article>?) {


        binding.executePendingBindings()
    }
}
