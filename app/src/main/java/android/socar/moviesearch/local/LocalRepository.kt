package android.socar.moviesearch.local

import android.content.Context

interface LocalRepository {
    fun saveSearchInformation(context: Context, list: List<String>)
    fun loadSearchInformation(context: Context)
}