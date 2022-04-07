package android.socar.moviesearch.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.socar.moviesearch.R
import android.socar.moviesearch.databinding.ActivityMovieInfoBinding
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil

class MovieInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieInfoBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_info)

        with(binding.wvMovieInformation) {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            intent.getStringExtra(MainActivity.WEB_ACTIVITY_KEY)?.let { url ->
                loadUrl(url)
            }
        }
    }
}