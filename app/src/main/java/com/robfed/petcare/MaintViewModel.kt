package com.robfed.petcare

import android.os.CountDownTimer
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository): ViewModel(){

    private val _uiState = MutableStateFlow("A")
    val uiState: StateFlow<String> = _uiState.asStateFlow()

    private val timer = object: CountDownTimer(10000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
        }

        override fun onFinish() {
            loadingFromRepository()
        }
    }

    init {
        timer.start()
    }

    fun loadingFromRepository() {
        _uiState.value = repository.getStringTest()
    }

}
