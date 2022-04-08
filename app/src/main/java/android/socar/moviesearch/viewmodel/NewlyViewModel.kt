package android.socar.moviesearch.viewmodel

import android.content.Context
import android.socar.moviesearch.local.LocalRepository
import android.util.Log
import androidx.lifecycle.ViewModel

class NewlyViewModel(
    private val localRepository: LocalRepository
): ViewModel() {

    fun loadSearchInformation(context: Context, addView: (search: String) -> Unit) {
        localRepository.loadSearchInformation(context).forEach { searchKeyword ->
            addView(searchKeyword)
        }
    }
}