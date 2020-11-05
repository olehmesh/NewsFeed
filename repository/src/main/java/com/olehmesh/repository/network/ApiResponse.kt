package com.olehmesh.repository.network

import com.google.gson.annotations.SerializedName
import com.olehmesh.repository.models.NewsModel

class ApiResponse(@SerializedName("data") var listItems: List<NewsModel>)
