package hu.bme.aut.dadjokes.ui.main

import hu.bme.aut.dadjokes.network.NetworkService
import hu.bme.aut.dadjokes.persistence.JokeDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val networkService: NetworkService,
    private val jokeDao: JokeDao
)