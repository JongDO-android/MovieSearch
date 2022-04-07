package android.socar.moviesearch.ui.adapter

import android.socar.moviesearch.remote.dto.MovieInformation
import androidx.recyclerview.widget.DiffUtil

object MovieDiffUtil: DiffUtil.ItemCallback<MovieInformation>() {
    override fun areItemsTheSame(oldItem: MovieInformation, newItem: MovieInformation): Boolean {
        return oldItem.imageUrl == newItem.imageUrl
    }

    override fun areContentsTheSame(oldItem: MovieInformation, newItem: MovieInformation): Boolean {
        return oldItem == newItem
    }

}