package android.socar.moviesearch.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("app:imageUrl")
fun setImageFromUrl(view: ImageView, url: String) {
    Glide.with(view).load(url).into(view)
}