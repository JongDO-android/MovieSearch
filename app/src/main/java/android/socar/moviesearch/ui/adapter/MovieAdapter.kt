package android.socar.moviesearch.ui.adapter

import android.socar.moviesearch.remote.dto.MovieInformation
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

class MovieAdapter(
    private val itemClickListener: MovieItemClickListener
): ListAdapter<MovieInformation, MovieViewHolder>(MovieDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder.from(parent, itemClickListener)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}