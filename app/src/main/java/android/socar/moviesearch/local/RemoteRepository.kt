package android.socar.moviesearch.local

import android.socar.moviesearch.remote.Result
import android.socar.moviesearch.remote.dto.MovieInformation

interface RemoteRepository {
    val searchList: List<String>
    suspend fun fetchMovieInfo(query: String, isFirst: Boolean): Result<List<MovieInformation>>
    fun clear()
}
