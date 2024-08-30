package com.architecture_pattern.presenter

import com.architecture_pattern.model.CounterContract
import com.architecture_pattern.model.CounterState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CounterPresenter(
    private val view: CounterContract.View
) : CounterContract.Presenter {

    private val _state = MutableStateFlow(CounterState())
    private val state: StateFlow<CounterState> = _state.asStateFlow()

    init {
        // Load initial state if needed
    }

    override fun increment() {
        _state.update { currentState ->
            currentState.copy(count = currentState.count + 1)
        }
        view.showCount(_state.value.count)
    }

    override fun decrement() {
        _state.update { currentState ->
            currentState.copy(count = currentState.count - 1)
        }
        view.showCount(_state.value.count)
    }

    override fun onViewReady() {
        // Any setup that needs to be done when the view is ready
        view.showCount(_state.value.count)
    }
}