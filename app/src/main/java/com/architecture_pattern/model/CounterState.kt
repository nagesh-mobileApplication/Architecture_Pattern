package com.architecture_pattern.model

data class CounterState(
    val count: Int = 0,
    val isLoading: Boolean = false,
    val error: String? = null
)
