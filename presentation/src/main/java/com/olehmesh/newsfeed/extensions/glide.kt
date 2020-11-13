package com.olehmesh.newsfeed.extensions

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.olehmesh.newsfeed.R
import de.hdodenhof.circleimageview.CircleImageView

fun CircleImageView.setLogo(logoURL: String?) {

        Glide.with(context)
                .load(logoURL)
                .apply(RequestOptions().encodeQuality(100))
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_placeholder)
                .into(this)
}

fun AppCompatImageView.setImageDetail(imgDetailURL: String?) {
        Glide.with(this).asBitmap()
                .load(imgDetailURL)
                .apply(RequestOptions().encodeQuality(100))
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_placeholder)
                .into(this)

}
