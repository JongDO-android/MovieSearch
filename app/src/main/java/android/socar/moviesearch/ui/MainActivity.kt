package android.socar.moviesearch.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.socar.moviesearch.R
import android.socar.moviesearch.databinding.ActivityMainBinding
import android.socar.moviesearch.di.ViewModelFactory
import android.socar.moviesearch.viewmodel.MainViewModel
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by lazy {
        ViewModelProvider(this, ViewModelFactory())[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

}