package hu.bme.aut.dadjokes.ui.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.dadjokes.model.Joke
import hu.bme.aut.dadjokes.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel() {
    private var _jokes = mutableStateOf(value = listOf<Joke>())
    val jokes: State<List<Joke>> get() = _jokes

    private val _isLoading = mutableStateOf(value = false)
    val isLoading: State<Boolean> get() = _isLoading

    init {
        loadInitialData()
    }

    fun requestMore() {
        viewModelScope.launch(context = Dispatchers.Main) {
            mainRepository.loadMoreJokes(
                onStart = { _isLoading.value = true },
                onCompletion = { _isLoading.value = false }
            ).collect {
                _jokes.value = it
            }
        }
    }

    private fun loadInitialData() {
        viewModelScope.launch(context = Dispatchers.Main) {
            mainRepository.getJokeList(
                onStart = { _isLoading.value = true },
                onCompletion = { _isLoading.value = false }
            ).collect {
                _jokes.value = it
            }
        }
    }
}