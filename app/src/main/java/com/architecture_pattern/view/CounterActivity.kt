package com.architecture_pattern.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.architecture_pattern.databinding.ActivityCounterBinding
import com.architecture_pattern.model.CounterContract
import com.architecture_pattern.presenter.CounterPresenter

class CounterActivity : AppCompatActivity(), CounterContract.View {

    private lateinit var presenter: CounterPresenter
    private val binding by lazy { ActivityCounterBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter = CounterPresenter(this)
        presenter.onViewReady()

        setupUI()
    }

    private fun setupUI() {
        binding.buttonIncrement.setOnClickListener {
            presenter.increment()
        }
        binding.buttonDecrement.setOnClickListener {
            presenter.decrement()
        }
    }

    override fun showCount(count: Int) {
        binding.textViewCount.text = count.toString()
    }

    override fun showError(message: String) {
        // Handle error messages (e.g., show a Toast or Snackbar)
    }
}