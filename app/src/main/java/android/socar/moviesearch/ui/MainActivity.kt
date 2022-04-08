package android.socar.moviesearch.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.socar.moviesearch.R
import android.socar.moviesearch.databinding.ActivityMainBinding
import android.socar.moviesearch.di.ViewModelFactory
import android.socar.moviesearch.ui.adapter.MovieAdapter
import android.socar.moviesearch.ui.adapter.MovieItemClickListener
import android.socar.moviesearch.viewmodel.MainViewModel
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity(), MovieItemClickListener {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by lazy {
        ViewModelProvider(this, ViewModelFactory())[MainViewModel::class.java]
    }
    private val movieAdapter: MovieAdapter by lazy {
        MovieAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        with(binding) {
            viewModel = mainViewModel
            rvSearchMovieResult.adapter = movieAdapter
        }
        mainViewModel.movieInformation.observe(this) {
            movieAdapter.submitList(it)
        }
        setClickListener()
    }

    private fun setClickListener() {
        with(binding) {
            btnSearchMovie.setOnClickListener {
                mainViewModel.fetchInformation(evMovieSearch.text.toString())
            }
            btnCurrentSearch.setOnClickListener {
                val intent = Intent(this@MainActivity, NewlyActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onItemClick(url: String) {
        val intent = Intent(this, MovieInfoActivity::class.java)
        intent.putExtra(WEB_ACTIVITY_KEY, url)
        startActivity(intent)
    }

    override fun onPause() {
        super.onPause()
        mainViewModel.saveSearchInformation(this)
    }

    companion object {
        const val WEB_ACTIVITY_KEY = "link"
        const val PREFERENCE_KEY = "searched_data"
    }
}