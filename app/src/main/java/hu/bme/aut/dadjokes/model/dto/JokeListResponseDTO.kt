package hu.bme.aut.dadjokes.model.dto

data class JokeListResponseDTO(
    val success: Boolean,
    val body: Array<JokeDTO>
)