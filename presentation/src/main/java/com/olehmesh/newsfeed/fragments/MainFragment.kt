package com.olehmesh.newsfeed.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.olehmesh.newsfeed.R
import com.olehmesh.newsfeed.adapters.MainAdapter
import com.olehmesh.newsfeed.extensions.itemDecorate
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    lateinit var mainAdapter: MainAdapter
    private val mainViewModel by viewModels<com.olehmesh.domain.MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mainViewModel.getData().observe(viewLifecycleOwner, { mainAdapter.submitList(it) })

        return inflater.inflate(R.layout.fragment_main, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mainAdapter = MainAdapter()

        recyclerMain.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mainAdapter
            itemDecorate()
        }

    }

}