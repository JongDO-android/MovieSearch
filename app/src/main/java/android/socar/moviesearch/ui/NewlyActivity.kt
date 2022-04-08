package android.socar.moviesearch.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.socar.moviesearch.R
import android.util.Log

class NewlyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newly)

        val sharedPref = getSharedPreferences(MainActivity.PREFERENCE_KEY, MODE_PRIVATE)
        Log.i("NewlyActivity :", sharedPref.getString(MainActivity.PREFERENCE_KEY, "") ?: "")
    }
}