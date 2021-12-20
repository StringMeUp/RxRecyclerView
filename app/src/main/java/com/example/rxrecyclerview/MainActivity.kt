package com.example.rxrecyclerview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.rxrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
        setupViewBinding()
        setupViewModelBinding()
    }

    private fun setupView() {
        _binding = ActivityMainBinding.inflate(layoutInflater)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val view = binding.root
        setContentView(view)
    }

    private fun setupViewBinding() {
        mainViewModel.apply {
            initRaw(context = this@MainActivity)
        }
    }

    private fun setupViewModelBinding() {
        mainViewModel.apply {
            headerData.observeNotNull(this@MainActivity, {
                Log.d("DATA", "setupViewModelBinding: $it ")
            })

            infoData.observeNotNull(this@MainActivity, {
                Log.d("DATA", "setupViewModelBinding: $it ")
            })

            profileData.observeNotNull(this@MainActivity, {
                Log.d("DATA", "setupViewModelBinding: $it ")
            })
        }
    }
}