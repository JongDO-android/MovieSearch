package android.socar.moviesearch.local

import android.socar.moviesearch.remote.Result
import android.socar.moviesearch.remote.dto.MovieInformation

interface Repository {
    suspend fun fetchMovieInfo(query: String): Result<List<MovieInformation>>
}
