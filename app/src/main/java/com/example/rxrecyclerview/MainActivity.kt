package com.example.rxrecyclerview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rxrecyclerview.base.RecyclerViewAdapter
import com.example.rxrecyclerview.databinding.ActivityMainBinding
import com.example.rxrecyclerview.utils.observeNotNull

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!

    private lateinit var mainViewModel: MainViewModel
    private lateinit var mainAdapter: RecyclerViewAdapter

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

        mainAdapter = RecyclerViewAdapter()
    }

    private fun setupViewBinding() {
        mainViewModel.apply {
            initRaw(context = this@MainActivity)
        }

        binding.apply {
            mainRecyclerView.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = mainAdapter
            }
        }
    }

    private fun setupViewModelBinding() {
        mainViewModel.apply {
            data.observeNotNull(this@MainActivity, {
                Log.d("DATA", "setupViewModelBinding: $it ")
                mainAdapter.updateData(it)
            })
        }
    }
}