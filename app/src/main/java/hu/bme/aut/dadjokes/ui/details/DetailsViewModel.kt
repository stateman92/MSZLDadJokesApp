package hu.bme.aut.dadjokes.ui.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.dadjokes.model.Joke
import hu.bme.aut.dadjokes.ui.NavScreen
import hu.bme.aut.dadjokes.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val detailRepository: DetailsRepository,
    savedStateHandle: SavedStateHandle
) : BaseViewModel() {
    private var _joke = mutableStateOf(value = Joke.mock())
    val joke: State<Joke> get() = _joke

    init {
        val jokeId = savedStateHandle.get<String>(NavScreen.Details.argument0)
        jokeId?.let {
            viewModelScope.launch(context = Dispatchers.Main) {
                detailRepository.getJokeById(id = it)
                    .collect {
                        it?.let {
                            _joke.value = it
                        }
                    }
            }
        }
    }
}