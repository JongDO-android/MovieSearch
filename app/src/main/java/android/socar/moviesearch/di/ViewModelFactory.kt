package android.socar.moviesearch.di

import android.socar.moviesearch.local.SearchRepository
import android.socar.moviesearch.viewmodel.MainViewModel
import android.socar.moviesearch.viewmodel.NewlyViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(SearchRepository(), SearchRepository()) as T
            }
            modelClass.isAssignableFrom(NewlyViewModel::class.java) -> {
                NewlyViewModel(SearchRepository()) as T
            }
            else -> throw IllegalArgumentException()
        }
    }
}