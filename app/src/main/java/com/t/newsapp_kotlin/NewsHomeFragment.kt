package com.t.newsapp_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.t.newsapp_kotlin.databinding.FragmentNewsHomeBinding
import kotlinx.android.synthetic.main.news_item.*

/**
 * A simple [Fragment] subclass.
 */
class NewsHomeFragment : Fragment() {

    /**
     * Lazily initialize our [NewsViewModel].
     */
    private val viewModel: NewsViewModel by lazy {
        ViewModelProviders.of(this).get(NewsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        //val binding = DataBindingUtil.inflate<FragmentNewsHomeBinding>(inflater,
        //    R.layout.fragment_news_home, container, false)
        val binding = FragmentNewsHomeBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.setLifecycleOwner (this)

        // Giving the binding access to the NewsViewModel
        binding.viewModel = viewModel
        //binding.newsItem.adapter = NewsAdapter()


        return binding.root
    }

}
