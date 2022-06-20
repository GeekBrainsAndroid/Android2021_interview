package ru.geekbrains.mviarchitecture.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
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

    private val _eventChannel = BroadcastChannel<MainIntent>(capacity = Channel.BUFFERED)

    val event: Flow<MainIntent> = _eventChannel.asFlow()

    private suspend fun newTest() {
        println("NewTestData viewModel")
        _eventChannel.send(MainIntent.NewTest)
    }

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
                    is MainIntent.Test -> test()
                    is MainIntent.TestData -> testData()
                    is MainIntent.NewTest -> newTest()
                }
            }
        }
    }



    private var count = 0

    private fun testData() {
        count++
        println("TestData viewModel $count")
        setStateValue(MainState.TestData(count))
    }

    private suspend fun test() {
        println("Test viewModel")
        setStateValue(MainState.Idle)
        delay(1)
        setStateValue(MainState.Test)
    }

//    println("Test viewModel")
//    setStateValue(MainState.Idle)
//    delay(1)

//    println("Test viewModel")
//    setStateValue(MainState.Idle)
//    delay(1)

    private fun fetchDaily() {
        viewModelScope.launch {
            setStateValue(MainState.Loading)
            setStateValue(
                try {
                    val model = Model(repository.getDaily().valute.map())
                    MainState.DailyData(model)
                } catch (e: Exception) {
                    MainState.Error(e.localizedMessage)
                }
            )
        }
    }
}