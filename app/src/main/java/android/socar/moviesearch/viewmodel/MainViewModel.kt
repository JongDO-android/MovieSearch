package android.socar.moviesearch.viewmodel

import android.socar.moviesearch.local.Repository
import android.socar.moviesearch.remote.Result
import android.socar.moviesearch.remote.dto.MovieInformation
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: Repository
): ViewModel() {
    private val _movieInfoList = MutableLiveData<List<MovieInformation>>()
    val movieInformation: LiveData<List<MovieInformation>> get() = _movieInfoList

    fun fetchInformation(query: String) {
        viewModelScope.launch {
            when(val result = repository.fetchMovieInfo(query)) {
                is Result.Success<List<MovieInformation>> -> _movieInfoList.value = result.data
                is Result.Error -> Log.e("MainViewModel :: ", "${result.exception}")
            }
        }
    }
}