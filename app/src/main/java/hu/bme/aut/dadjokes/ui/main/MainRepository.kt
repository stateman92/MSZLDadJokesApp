package hu.bme.aut.dadjokes.ui.main

import androidx.annotation.WorkerThread
import hu.bme.aut.dadjokes.network.NetworkService
import hu.bme.aut.dadjokes.persistence.JokeDao
import hu.bme.aut.dadjokes.ui.base.BaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val networkService: NetworkService,
    private val jokeDao: JokeDao
): BaseRepository() {
    @WorkerThread
    fun getJokeList() = flow {
        val jokeList = jokeDao.getJokeList()
        emit(jokeList)
    }.flowOn(Dispatchers.IO)
}