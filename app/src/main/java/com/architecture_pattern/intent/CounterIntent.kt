package com.architecture_pattern.intent

sealed class CounterIntent {
    object Increment : CounterIntent()
    object Decrement : CounterIntent()
}