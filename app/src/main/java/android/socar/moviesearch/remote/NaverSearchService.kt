package android.socar.moviesearch.remote

import android.socar.moviesearch.remote.dto.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NaverSearchService {
    @GET("/v1/search/movie.json")
    suspend fun searchMovieInfo(
        @Header("X-Naver-Client-Id") clientId: String,
        @Header("X-Naver-Client-Secret") clientSecret: String,
        @Query("query") search: String,
        @Query("display") display: Int = 50
    ): MovieResponse
}