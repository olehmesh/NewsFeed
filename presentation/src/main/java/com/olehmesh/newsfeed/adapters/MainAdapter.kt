package com.olehmesh.newsfeed.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.olehmesh.newsfeed.R
import com.olehmesh.newsfeed.databinding.MainListItemBinding
import com.olehmesh.newsfeed.utils.Constants
import com.olehmesh.newsfeed.utils.DiffUtilCallBack
import com.olehmesh.repository.models.NewsModel
import kotlinx.android.extensions.LayoutContainer

class MainAdapter : PagedListAdapter<NewsModel, MainAdapter.ItemViewHolder>(DiffUtilCallBack()) {

    private lateinit var navController: NavController

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val v = LayoutInflater.from(parent.context)

        val binding = MainListItemBinding.inflate(v, parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(itemViewHolder: ItemViewHolder, i: Int) {

        val mList: NewsModel? = getItem(i)
        when {
            mList != null -> {
                itemViewHolder.bind(mList)
            }
        }

        itemViewHolder.itemView.setOnClickListener {

            navController = Navigation.findNavController(itemViewHolder.itemView)

            val bundle = Bundle()

            bundle.putString(Constants.TITLE_NEWS, mList?.title)
            bundle.putString(Constants.DESC_NEWS, mList?.text)
            bundle.putString(Constants.IMAGE_NEWS, mList?.image_url)

            navController.navigate(
                R.id.fragment_detail,
                bundle,
            )

        }

    }

    inner class ItemViewHolder(private val binding: MainListItemBinding) :
        RecyclerView.ViewHolder(binding.root), LayoutContainer {

        override val containerView: View?
            get() = itemView


        fun bind(item: NewsModel) {

            binding.data = item
            binding.executePendingBindings()

        }

    }

}