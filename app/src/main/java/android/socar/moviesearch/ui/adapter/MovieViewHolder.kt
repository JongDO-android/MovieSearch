package android.socar.moviesearch.ui.adapter

import android.socar.moviesearch.databinding.LayoutMovieItemBinding
import android.socar.moviesearch.remote.dto.MovieInformation
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MovieViewHolder(
    private val binding: LayoutMovieItemBinding,
    private val itemClickListener: MovieItemClickListener
): RecyclerView.ViewHolder(binding.root) {

    fun bind(movieInfo: MovieInformation) {
        binding.movieInformation = movieInfo
        itemView.setOnClickListener { itemClickListener.onItemClick(movieInfo.link) }
    }

    companion object {
        fun from(
            parent: ViewGroup,
            itemClickListener: MovieItemClickListener
        ): MovieViewHolder {
            return MovieViewHolder(
                LayoutMovieItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                itemClickListener
            )
        }
    }
}