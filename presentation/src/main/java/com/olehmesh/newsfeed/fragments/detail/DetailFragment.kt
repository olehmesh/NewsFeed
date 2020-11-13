package com.olehmesh.newsfeed.fragments.detail

import android.os.Bundle
import android.view.View
import com.olehmesh.newsfeed.base.BaseFragment
import com.olehmesh.newsfeed.databinding.FragmentDetailBinding
import com.olehmesh.newsfeed.extensions.setImageDetail
import com.olehmesh.newsfeed.utils.Constants

class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.imgDetail?.setImageDetail(requireArguments().getString(Constants.IMAGE_NEWS))
        binding?.tvDetailTitle?.text = requireArguments().getString(Constants.TITLE_NEWS)
        binding?.tvText?.text = requireArguments().getString(Constants.DESC_NEWS)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}