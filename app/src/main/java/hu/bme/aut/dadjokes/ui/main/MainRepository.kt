package hu.bme.aut.dadjokes.ui.main

import androidx.annotation.WorkerThread
import com.skydoves.sandwich.*
import hu.bme.aut.dadjokes.model.mapping.toJokes
import hu.bme.aut.dadjokes.network.NetworkService
import hu.bme.aut.dadjokes.persistence.JokeDao
import hu.bme.aut.dadjokes.ui.base.BaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val networkService: NetworkService,
    private val jokeDao: JokeDao
): BaseRepository() {
    @WorkerThread
    fun loadJokeList(
        onStart: () -> Unit,
        onCompletion: () -> Unit,
        onError: (String) -> Unit
    ) = flow {
        val jokes = jokeDao.getJokeList()
        if (jokes.isEmpty()) {
            networkService.getJokeList("10")
                .suspendOnSuccess {
                    val jokes = data.toJokes()
                    jokeDao.insertJokeList(jokes)
                    emit(jokes)
                }
                .onError {
                    onError(message())
                }
                .onException {
                    onError(message())
                }
        } else {
            emit(jokes)
        }
    }.onStart { onStart() }.onCompletion { onCompletion() }.flowOn(Dispatchers.IO)
}