package com.olehmesh.repository.models

import com.google.gson.annotations.SerializedName

data class NewsModel(

        @SerializedName("title")
        var title: String? = "",

        @SerializedName("image")
        var image_url: String? = "",

        @SerializedName("teaser")
        var text: String? = ""
)