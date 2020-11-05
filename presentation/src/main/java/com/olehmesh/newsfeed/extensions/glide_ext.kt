package com.olehmesh.newsfeed.extensions

import android.graphics.drawable.Drawable
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import de.hdodenhof.circleimageview.CircleImageView

@BindingAdapter("picture", "errorImage")
fun CircleImageView.loadImage(
    imageURL: String?,
    errorImage: Drawable
) {

    Glide.with(context)
        .load(imageURL?.replace("http://", "https://"))
        .apply(RequestOptions().encodeQuality(100))
        .placeholder(errorImage)
        .error(errorImage)
        .into(this)

}
