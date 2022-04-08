package android.socar.moviesearch.local

import android.content.Context
import android.socar.moviesearch.common.NaverApi
import android.socar.moviesearch.common.PreferenceManager
import android.socar.moviesearch.remote.RetrofitBuilder
import android.socar.moviesearch.remote.dto.MovieInformation
import android.socar.moviesearch.remote.Result
import android.socar.moviesearch.ui.MainActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
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
            if(!_searchList.contains(query)) {
                _searchList.add(query)
            }

            Result.Success(result.items)
        } catch (e: HttpException) {
            Result.Error(e)
        }
    }

    override fun saveSearchInformation(context: Context, list: List<String>) {
        val sharedPref = PreferenceManager.getSharedPreference(context)
        val gson = Gson()
        val json = sharedPref.getString(MainActivity.SEARCHED_INFO_KEY, "[]")
        val type = object : TypeToken<List<String>>() {}.type
        val searched = gson.fromJson<List<String>>(json, type).toMutableList()

        searched.addAll(list)
        while(searched.size > 10) {
            searched.removeAt(0)
        }

        with(sharedPref.edit()) {
            putString(MainActivity.SEARCHED_INFO_KEY, gson.toJson(searched))
            apply()
        }
    }

    override fun loadSearchInformation(context: Context): List<String> {
        val sharedPref = PreferenceManager.getSharedPreference(context)
        val json = sharedPref.getString(MainActivity.SEARCHED_INFO_KEY, "[]")
        val type = object : TypeToken<List<String>>() {}.type

        return Gson().fromJson(json, type)
    }

    override fun clear() {
        _searchList.clear()
    }
}