package hu.bme.aut.dadjokes.model.dto

import hu.bme.aut.dadjokes.model.dto.JokeDTO

data class JokeListResponseDTO (
    val success: Boolean,
    val body: Array<JokeDTO>
)