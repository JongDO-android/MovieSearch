package android.socar.moviesearch.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieInformation(
    @SerializedName("title") val title: String,
    @SerializedName("link") val link: String,
    @SerializedName("image") val imageUrl: String,
    @SerializedName("pubDate") val publishDate: String,
    @SerializedName("userRating") val userRating: String
)
