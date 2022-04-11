package hu.bme.aut.dadjokes.ui.details

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.dadjokes.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val detailRepository: DetailsRepository
): BaseViewModel() {
    private val jokeIdSharedFlow: MutableSharedFlow<Long> = MutableSharedFlow(replay = 1)

    val jokeDetailsFlow = jokeIdSharedFlow.flatMapLatest {
        detailRepository.getJokeById(it)
    }

    fun loadJOkeById(id: Long) = jokeIdSharedFlow.tryEmit(id)
}