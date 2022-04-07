package android.socar.moviesearch.local

import android.socar.moviesearch.remote.RetrofitBuilder

class SearchRepository: Repository {
    private val retrofit = RetrofitBuilder.create()

    override suspend fun fetchMovieInfo() {

    }
}