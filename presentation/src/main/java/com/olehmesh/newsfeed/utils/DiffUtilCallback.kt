package com.olehmesh.newsfeed.utils

import androidx.recyclerview.widget.DiffUtil
import com.olehmesh.repository.models.NewsModel


class DiffUtilCallBack : DiffUtil.ItemCallback<NewsModel>() {
    override fun areItemsTheSame(oldItem: NewsModel, newItem: NewsModel): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: NewsModel, newItem: NewsModel): Boolean {
        return oldItem == newItem
    }

}