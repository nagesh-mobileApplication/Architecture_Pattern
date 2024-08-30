package com.architecture_pattern.model

interface CounterContract {

    interface View {
        fun showCount(count: Int)
        fun showError(message: String)
    }

    interface Presenter {
        fun increment()
        fun decrement()
        fun onViewReady()
    }
}