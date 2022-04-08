package android.socar.moviesearch.common

import android.content.Context
import android.content.SharedPreferences
import android.socar.moviesearch.ui.MainActivity

object PreferenceManager {

    fun getSharedPreference(context: Context): SharedPreferences {
        return context.getSharedPreferences(MainActivity.PREFERENCE_KEY, Context.MODE_PRIVATE)
    }
}