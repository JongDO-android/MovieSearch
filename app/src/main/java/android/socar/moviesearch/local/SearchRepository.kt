package android.socar.moviesearch.local

import android.content.Context
import android.socar.moviesearch.common.NaverApi
import android.socar.moviesearch.remote.RetrofitBuilder
import android.socar.moviesearch.remote.dto.MovieInformation
import android.socar.moviesearch.remote.Result
import android.socar.moviesearch.ui.MainActivity
import com.google.gson.Gson
import retrofit2.HttpException

class SearchRepository: RemoteRepository, LocalRepository {
    private val service = RetrofitBuilder.create()
    private val _searchList = mutableListOf<String>()
    override val searchList: List<String> get() = _searchList

    override suspend fun fetchMovieInfo(query: String): Result<List<MovieInformation>> {
        return try {
            val result = service.searchMovieInfo(
                NaverApi.CLIENT_ID,
                NaverApi.CLIENT_SECRET,
                query
            )
            if(_searchList.size == 10) {
                _searchList.removeAt(0)
            }
            _searchList.add(query)
            Result.Success(result.items)
        } catch (e: HttpException) {
            Result.Error(e)
        }
    }

    override fun saveSearchInformation(context: Context, list: List<String>) {
        val sharedPref = context.getSharedPreferences(
            MainActivity.PREFERENCE_KEY,
            Context.MODE_PRIVATE
        )

        val searched = Gson().toJson(list)
        with(sharedPref.edit()) {
            putString(MainActivity.PREFERENCE_KEY, searched)
            apply()
        }
    }

    override fun loadSearchInformation(context: Context) {
        
    }
}