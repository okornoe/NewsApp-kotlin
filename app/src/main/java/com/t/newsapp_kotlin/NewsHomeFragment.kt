package com.t.newsapp_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.t.newsapp_kotlin.databinding.FragmentNewsHomeBinding

/**
 * A simple [Fragment] subclass.
 */
class NewsHomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentNewsHomeBinding>(inflater, R.layout.fragment_news_home, container, false)

        val adapter = NewsAdapter()
        binding.newsList.adapter = adapter
        adapter.listNames

        return binding.root
    }

}
