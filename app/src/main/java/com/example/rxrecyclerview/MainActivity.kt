package com.example.rxrecyclerview

import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
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
        mainAdapter.observeClickListener().subscribe {
            TransitionManager.beginDelayedTransition(binding.mainRecyclerView)
            mainViewModel.updateData(it)
        }
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
                mainAdapter.updateData(it)
            })
        }
    }
}