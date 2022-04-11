package hu.bme.aut.dadjokes.ui.details

import androidx.annotation.WorkerThread
import hu.bme.aut.dadjokes.persistence.JokeDao
import hu.bme.aut.dadjokes.ui.base.BaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DetailsRepository @Inject constructor(
    private val jokeDao: JokeDao
): BaseRepository() {
    @WorkerThread
    fun getJokeById(id: Long) = flow {
        val joke = jokeDao.getJoke(id)
        emit(joke)
    }.flowOn(Dispatchers.IO)
}
