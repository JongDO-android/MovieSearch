package android.socar.moviesearch.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.socar.moviesearch.R
import android.socar.moviesearch.databinding.ActivityNewlyBinding
import android.socar.moviesearch.di.ViewModelFactory
import android.socar.moviesearch.viewmodel.NewlyViewModel
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

class NewlyActivity : AppCompatActivity() {
    private val binding: ActivityNewlyBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_newly)
    }
    private val newlyViewModel: NewlyViewModel by lazy {
        ViewModelProvider(this, ViewModelFactory())[NewlyViewModel::class.java]
    }
    private val addView = { search: String ->
        val button = Button(this).apply {
            text = search
            setTextColor(ContextCompat.getColor(this@NewlyActivity, R.color.white))
            background = ContextCompat.getDrawable(
                this@NewlyActivity,
                R.drawable.button_shape
            )
        }
        binding.lvSearchLogList.addView(button)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding
        newlyViewModel.loadSearchInformation(this, addView)
    }

}