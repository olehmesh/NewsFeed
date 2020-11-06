package com.olehmesh.newsfeed.extensions

import android.graphics.drawable.Drawable
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import de.hdodenhof.circleimageview.CircleImageView

@BindingAdapter("picture", "errorImage")
fun CircleImageView.setLogo(
        logoURL: String?,
        errorImage: Drawable
) {

    Glide.with(context)
            .load(toHttps(logoURL))
            .apply(RequestOptions().encodeQuality(100))
            .placeholder(errorImage)
            .error(errorImage)
            .into(this)

}

fun CircleImageView.setImageDetail(imgDetailURL: String?) {
    Glide.with(this).asBitmap()
            .load(toHttps(imgDetailURL))
            .apply(RequestOptions().encodeQuality(100))
            .into(this)

}

fun toHttps(urlHttp: String?): String? {
    return urlHttp?.replace("http://", "https://")
}