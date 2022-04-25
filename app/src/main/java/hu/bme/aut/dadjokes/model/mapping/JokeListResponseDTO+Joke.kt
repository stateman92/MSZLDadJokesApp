package hu.bme.aut.dadjokes.model.mapping

import hu.bme.aut.dadjokes.model.dto.JokeListResponseDTO

fun JokeListResponseDTO.toJokes() = body.map { it.toJoke() }