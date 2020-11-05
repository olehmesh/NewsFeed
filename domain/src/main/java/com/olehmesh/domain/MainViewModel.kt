package com.olehmesh.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.olehmesh.repository.KeyedDataSource
import com.olehmesh.repository.models.NewsModel
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {

    var liveNews: LiveData<PagedList<NewsModel>>

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(10)
            .setEnablePlaceholders(false)
            .build()

        liveNews = initPagedList(config).build()


    }

    fun getData(): LiveData<PagedList<NewsModel>> = liveNews


    private fun initPagedList(config: PagedList.Config): LivePagedListBuilder<String, NewsModel> {

        val dataSourceFactory = object : DataSource.Factory<String, NewsModel>() {

            override fun create(): DataSource<String, NewsModel> {

                return KeyedDataSource(Dispatchers.Main)

            }
        }

        return LivePagedListBuilder(dataSourceFactory, config)

    }
}