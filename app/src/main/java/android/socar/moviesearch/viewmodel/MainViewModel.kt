package android.socar.moviesearch.viewmodel

import android.content.Context
import android.socar.moviesearch.local.LocalRepository
import android.socar.moviesearch.local.RemoteRepository
import android.socar.moviesearch.remote.Result
import android.socar.moviesearch.remote.dto.MovieInformation
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
): ViewModel() {
    private val _movieInfoList = MutableLiveData<List<MovieInformation>>()
    val movieInformation: LiveData<List<MovieInformation>> get() = _movieInfoList

    fun fetchInformation(query: String) {
        viewModelScope.launch {
            when(val result = remoteRepository.fetchMovieInfo(query)) {
                is Result.Success<List<MovieInformation>> -> _movieInfoList.value = result.data
                is Result.Error -> Log.e("MainViewModel :: ", "${result.exception}")
            }
        }
    }

    fun saveSearchInformation(context: Context) {
        localRepository.saveSearchInformation(context, remoteRepository.searchList)
        remoteRepository.clear()
    }
}