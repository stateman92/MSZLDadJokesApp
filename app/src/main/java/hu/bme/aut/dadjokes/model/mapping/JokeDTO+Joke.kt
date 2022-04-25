package hu.bme.aut.dadjokes.model.mapping

import hu.bme.aut.dadjokes.model.Joke
import hu.bme.aut.dadjokes.model.dto.JokeDTO

fun JokeDTO.toJoke() = Joke(
    id = _id ?: "",
    headline = setup,
    punchline = punchline,
    type = type,
    author = author?.toAuthor() ?: "",
    date = date ?: 0,
    NSFW = NSFW ?: false
)