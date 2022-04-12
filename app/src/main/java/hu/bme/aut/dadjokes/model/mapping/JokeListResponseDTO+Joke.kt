package hu.bme.aut.dadjokes.model.mapping

import hu.bme.aut.dadjokes.model.Joke
import hu.bme.aut.dadjokes.model.dto.JokeListResponseDTO

fun JokeListResponseDTO.toJokes(): List<Joke> = body.map {
    Joke(
        id = it._id ?: "",
        headline = it.setup,
        punchline = it.punchline,
        type = it.type,
        author = it.author?.name ?: "",
        date = it.date ?: 0,
        NSFW = it.NSFW ?: false
    )
}