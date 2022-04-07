package android.socar.moviesearch.local

interface Repository {
    suspend fun fetchMovieInfo()
}
