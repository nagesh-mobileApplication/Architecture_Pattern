package com.architecture_pattern.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.architecture_pattern.databinding.ActivityCounterBinding
import com.architecture_pattern.viewmodel.CounterViewModel
import com.architecture_pattern.intent.CounterIntent
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CounterActivity : AppCompatActivity() {

    private val viewModel: CounterViewModel by viewModels()
    private val binding by lazy { ActivityCounterBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupUI()
        observeState()
    }

    private fun setupUI() {
        binding.buttonIncrement.setOnClickListener {
            viewModel.handleIntent(CounterIntent.Increment)
        }
        binding.buttonDecrement.setOnClickListener {
            viewModel.handleIntent(CounterIntent.Decrement)
        }
    }

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collectLatest { state ->
                    binding.textViewCount.text = state.count.toString()
                }
            }
        }
    }
}