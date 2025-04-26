package com.piriurna.pokepockettrader.ui.root

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow


interface UiState

abstract class BaseViewModel<T: UiState>(): ViewModel() {

    protected abstract fun initialValue(): T

    private val _uiState: MutableState<T> = mutableStateOf(initialValue())
    val uiState: State<T> = _uiState

    protected fun updateState(uiState: T) {
        _uiState.value = uiState
    }
}