package com.olehmesh.repository.models

import com.google.gson.annotations.SerializedName

data class NewsModel(

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("image")
    var image_url: String? = null,

    @SerializedName("teaser")
    var text: String? = null
)