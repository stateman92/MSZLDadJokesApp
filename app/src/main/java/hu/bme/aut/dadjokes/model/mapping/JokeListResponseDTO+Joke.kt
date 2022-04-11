package hu.bme.aut.dadjokes.model.mapping

import hu.bme.aut.dadjokes.model.Joke
import hu.bme.aut.dadjokes.model.dto.JokeListResponseDTO

fun JokeListResponseDTO.toJokes(): List<Joke> = body.map {
    Joke(
        it._id ?: "",
        it.setup,
        it.punchline,
        it.type,
        it.author?.name ?: "",
        it.date ?: 0,
        it.NSFW ?: false
    )
}