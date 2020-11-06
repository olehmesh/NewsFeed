package com.olehmesh.newsfeed.fragments.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.olehmesh.newsfeed.R
import com.olehmesh.newsfeed.base.BaseFragment
import com.olehmesh.newsfeed.databinding.FragmentDetailBinding
import com.olehmesh.newsfeed.extensions.setImageDetail
import com.olehmesh.newsfeed.utils.Constants
import com.olehmesh.repository.models.NewsModel

class DetailFragment : BaseFragment() {

    override val layoutResId: Int
        get() = R.layout.fragment_detail

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        val detail = NewsModel(
            requireArguments().getString(Constants.TITLE_NEWS),
            requireArguments().getString(Constants.IMAGE_NEWS),
            requireArguments().getString(Constants.DESC_NEWS)
        )

        binding.data = detail
        binding.imgDetail.setImageDetail(binding.data?.image_url)

        return binding.root

    }
}