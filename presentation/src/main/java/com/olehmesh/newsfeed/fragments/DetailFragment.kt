package com.olehmesh.newsfeed.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.olehmesh.newsfeed.R
import com.olehmesh.newsfeed.databinding.FragmentDetailBinding
import com.olehmesh.repository.models.NewsModel
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    private lateinit var navController: NavController

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentDetailBinding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        val detail = NewsModel(
                        requireArguments().getString("title"),
                        requireArguments().getString("image"),
                        requireArguments().getString("text")
               )
        binding.data = detail
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Glide.with(this).asBitmap()
            .load(requireArguments().getString("image")?.replace("http://", "https://"))
            .apply(RequestOptions().encodeQuality(100))
            .into(ivDetailLarge)

    }

}