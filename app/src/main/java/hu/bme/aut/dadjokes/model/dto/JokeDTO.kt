package hu.bme.aut.dadjokes.model.dto

data class JokeDTO(
    val type: String,
    val setup: String,
    val punchline: String,
    val _id: String? = null,
    val author: AuthorDTO? = null,
    val approved: Boolean? = null,
    val date: Int? = null,
    val NSFW: Boolean? = null
)