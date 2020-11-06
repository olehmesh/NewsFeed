package com.olehmesh.newsfeed.fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.olehmesh.newsfeed.R
import com.olehmesh.newsfeed.adapters.MainAdapter
import com.olehmesh.newsfeed.base.BaseFragment
import com.olehmesh.newsfeed.extensions.itemDecorate
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment() {

    override val layoutResId: Int
        get() = R.layout.fragment_main

    lateinit var mainAdapter: MainAdapter
    private val mainViewModel by viewModels<com.olehmesh.domain.MainViewModel>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mainAdapter = MainAdapter()

        mainViewModel.getData().observe(viewLifecycleOwner, { mainAdapter.submitList(it) })

        recyclerMain.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mainAdapter
            itemDecorate()
        }

    }

}