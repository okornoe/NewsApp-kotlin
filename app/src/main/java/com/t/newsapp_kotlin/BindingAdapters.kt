package com.t.newsapp_kotlin

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


/*@BindingAdapter("urlToImage")

fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()

        Glide.with(imgView.context)
            .load(imgUri)
            .into(imgView)
    }
*/

    @BindingAdapter("articles")
    fun bindRecyclerView(recyclerView: RecyclerView,
                         data: List<NewsData>) {
        val adapter = recyclerView.adapter as NewsAdapter
            adapter.submitList(data)
        }

