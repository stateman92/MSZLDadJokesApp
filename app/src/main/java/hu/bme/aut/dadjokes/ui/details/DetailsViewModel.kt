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
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val detailRepository: DetailsRepository,
    savedStateHandle: SavedStateHandle
) : BaseViewModel() {
    private var _joke = mutableStateOf(Joke.mock())
    val joke: State<Joke> get() = _joke

    init {
        val jokeId = savedStateHandle.get(NavScreen.Details.argument0) as? String
        jokeId?.let {
            viewModelScope.launch(Dispatchers.Main) {
                detailRepository.getJokeById(it)
                    .collect {
                        it?.let {
                            _joke.value = it
                        }
                    }
            }
        }
    }
}