package hu.bme.aut.dadjokes.ui.main

import androidx.annotation.WorkerThread
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.suspendOnSuccess
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
) : BaseRepository() {
    @WorkerThread
    fun getJokeList(
        onStart: () -> Unit,
        onCompletion: () -> Unit,
        onError: (String) -> Unit
    ) = flow {
        val jokes = jokeDao.getJokeList()
        if (jokes.isEmpty()) {
            networkService.getJokeList("5")
                .suspendOnSuccess {
                    val newJokes = data.toJokes() + jokes
                    jokeDao.insertJokeList(newJokes)
                    emit(newJokes)
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

    @WorkerThread
    fun load(
        onStart: () -> Unit,
        onCompletion: () -> Unit,
        onError: (String) -> Unit
    ) = flow {
        val jokes = jokeDao.getJokeList()
        networkService.getJokeList("5")
            .suspendOnSuccess {
                val newJokes = data.toJokes() + jokes
                jokeDao.insertJokeList(newJokes)
                emit(newJokes)
            }
            .onError {
                onError(message())
            }
            .onException {
                onError(message())
            }
    }.onStart { onStart() }.onCompletion { onCompletion() }.flowOn(Dispatchers.IO)
}