package com.architecture_pattern.viewmodel

import androidx.lifecycle.ViewModel
import com.architecture_pattern.model.CounterState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CounterViewModel : ViewModel() {

    private val _state = MutableStateFlow(CounterState())
    val state: StateFlow<CounterState> = _state.asStateFlow()

    fun increment() {
        _state.update { currentState ->
            currentState.copy(count = currentState.count + 1)
        }
    }

    fun decrement() {
        _state.update { currentState ->
            currentState.copy(count = currentState.count - 1)
        }
    }
}