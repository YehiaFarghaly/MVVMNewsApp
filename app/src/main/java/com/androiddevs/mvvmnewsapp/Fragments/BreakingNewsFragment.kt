package com.androiddevs.mvvmnewsapp.Fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.androiddevs.mvvmnewsapp.MainActivity
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.adapters.NewsAdapter
import com.androiddevs.mvvmnewsapp.ui.NewsViewModel
import com.androiddevs.mvvmnewsapp.utils.Resource
import kotlinx.android.synthetic.main.fragment_breaking_news.*

class BreakingNewsFragment: Fragment(R.layout.fragment_breaking_news) {
    lateinit var viewModel:NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    private val TAG = "BreakingNewsError"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        setUpRecyclerView()
        viewModel.breakingNews.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Success->{
                    hideProgressBar()
                    it.data?.let {
                        newsResponse->
                        newsAdapter.differ.submitList(newsResponse.articles)
                    }
                }
                is Resource.Error->{
                    hideProgressBar()
                    it.message?.let {
                        message-> Log.e(TAG,"An Error Occured $message")
                    }
                }
                else-> {
                    showProgressBar()
                }
            }
        })
    }

    private fun setUpRecyclerView(){
        newsAdapter = NewsAdapter()
        rvBreakingNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
    private fun hideProgressBar() {
        paginationProgressBar.visibility = View.INVISIBLE
    }
    private fun showProgressBar(){
        paginationProgressBar.visibility = View.VISIBLE
    }
}