package android.socar.moviesearch.di

import android.socar.moviesearch.local.SearchRepository
import android.socar.moviesearch.viewmodel.MainViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(SearchRepository()) as T
        } else {
            throw IllegalArgumentException()
        }
    }
}