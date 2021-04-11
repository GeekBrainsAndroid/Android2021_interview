package ru.geekbrains.mviarchitecture.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import ru.geekbrains.mviarchitecture.repository.MainRepository
import ru.geekbrains.mviarchitecture.ui.MainIntent
import ru.geekbrains.mviarchitecture.ui.MainState
import ru.geekbrains.mviarchitecture.ui.model.Model
import ru.geekbrains.mviarchitecture.mapping.map

class MainViewModel(private val repository: MainRepository) : ViewModel() {
    val userIntent = Channel<MainIntent>(Channel.UNLIMITED)
    private val _state = MutableStateFlow<MainState>(MainState.Idle)
    val state: StateFlow<MainState> get() = _state

    private fun setStateValue(value: MainState) {
        _state.value = value
    }

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            userIntent.consumeAsFlow().collect {
                when (it) {
                    is MainIntent.FetchDaily -> fetchDaily()
                }
            }
        }
    }

    private fun fetchDaily() {
        viewModelScope.launch {
            setStateValue(MainState.Loading)
            setStateValue( try {
                val model = Model(repository.getDaily().valute.map())
                MainState.DailyData(model)
            } catch (e: Exception) {
                MainState.Error(e.localizedMessage)
            })
        }
    }
}