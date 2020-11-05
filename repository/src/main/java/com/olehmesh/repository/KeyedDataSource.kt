package com.olehmesh.repository

import android.util.Log
import androidx.paging.ItemKeyedDataSource
import com.olehmesh.repository.di.App
import com.olehmesh.repository.models.NewsModel
import com.olehmesh.repository.network.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class KeyedDataSource(context: CoroutineContext) : ItemKeyedDataSource<String, NewsModel>() {

    @Inject
    lateinit var api: ApiService

    private val job = Job()
    private val scope = CoroutineScope(context + job)

    override fun loadInitial(
        params: LoadInitialParams<String?>,
        callback: LoadInitialCallback<NewsModel?>
    ) {

        App.component.inject(this)

        scope.launch {
            try {
                val response = api.getData(loadSize = params.requestedLoadSize)
                when {

                    response.isSuccessful -> {
                        val list = response.body()?.listItems
                        list?.let { callback.onResult(it) }
                    }
                }

            } catch (exception: Exception) {
                Log.e("Paging", "No data")
            }

        }

    }

    override fun loadAfter(params: LoadParams<String?>, callback: LoadCallback<NewsModel?>) {

        scope.launch {

            try {
                val response = api.getData(after = params.requestedLoadSize)
                when {
                    response.isSuccessful -> {
                        val list = response.body()?.listItems
                        list?.let { callback.onResult(it) }
                    }
                }

            } catch (exception: Exception) {
                Log.e("Paging", "No data")
            }

        }
    }

    override fun loadBefore(params: LoadParams<String?>, callback: LoadCallback<NewsModel?>) {
        scope.launch {
            try {
                val response = api.getData(after = params.requestedLoadSize)
                when {
                    response.isSuccessful -> {
                        val list = response.body()?.listItems
                        list?.let { callback.onResult(it) }
                    }
                }

            } catch (exception: Exception) {
                Log.e("Paging", "No data")
            }

        }

    }

    override fun getKey(item: NewsModel): String {
        return item.toString()
    }

}