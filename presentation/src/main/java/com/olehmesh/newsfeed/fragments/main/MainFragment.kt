package com.olehmesh.newsfeed.fragments.main

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.olehmesh.newsfeed.adapters.MainAdapter
import com.olehmesh.newsfeed.base.BaseFragment
import com.olehmesh.newsfeed.databinding.FragmentMainBinding
import com.olehmesh.newsfeed.extensions.itemDecorate

class MainFragment : BaseFragment<FragmentMainBinding>() {

    lateinit var mainAdapter: MainAdapter
    private val mainViewModel by viewModels<com.olehmesh.domain.MainViewModel>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mainAdapter = MainAdapter()

        mainViewModel.getData().observe(viewLifecycleOwner, { mainAdapter.submitList(it) })

        binding?.recyclerMain?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mainAdapter
            itemDecorate()
        }

    }

}