package hu.bme.aut.dadjokes

import hu.bme.aut.dadjokes.model.Joke

object MockTestUtil {
    fun mockJokeList() = listOf(Joke.mock())
}
