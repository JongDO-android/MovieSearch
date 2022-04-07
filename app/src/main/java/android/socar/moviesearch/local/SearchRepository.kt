package android.socar.moviesearch.local

import android.socar.moviesearch.common.NaverApi
import android.socar.moviesearch.remote.RetrofitBuilder
import android.socar.moviesearch.remote.dto.MovieInformation
import android.socar.moviesearch.remote.Result
import retrofit2.HttpException

class SearchRepository: Repository {
    private val service = RetrofitBuilder.create()

    override suspend fun fetchMovieInfo(query: String): Result<List<MovieInformation>> {
        return try {
            val result = service.searchMovieInfo(
                NaverApi.CLIENT_ID,
                NaverApi.CLIENT_SECRET,
                query
            )
            Result.Success(result.items)
        } catch (e: HttpException) {
            Result.Error(e)
        }
    }
}