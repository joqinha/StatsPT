package com.joaoferreira.statspt.presentation.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaoferreira.ine_data.local.IneDao
import com.joaoferreira.ine_domain.repository.IneRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val ineRepository: IneRepository,
) : ViewModel() {

    companion object {
        private const val TAG = "MyViewModel"
    }

    private val _value = MutableStateFlow(0)
    val value = _value.asStateFlow()


    init {
        viewModelScope.launch {
            val call = ineRepository.getIndicador(2021)
            if (call.isSuccess) {
                _value.value = call.getOrNull()?.toInt() ?: 0
            } else {
                val exception = call.exceptionOrNull()
                Log.e(TAG, "Failure: $exception")
            }
        }
    }
}