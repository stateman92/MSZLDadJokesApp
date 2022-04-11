package hu.bme.aut.dadjokes.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.dadjokes.model.Joke
import hu.bme.aut.dadjokes.ui.base.BaseViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

@HiltViewModel
class MainViewModel @Inject constructor(
    mainRepository: MainRepository
) : BaseViewModel() {
    val jokeList: Flow<List<Joke>> =
        mainRepository.loadJokeList(
            onStart = { _isLoading.value = true },
            onCompletion = { _isLoading.value = false },
            onError = {  }
        )

    private val _isLoading: MutableState<Boolean> = mutableStateOf(false)
    val isLoading: State<Boolean> get() = _isLoading
}