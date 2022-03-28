package hu.bme.aut.dadjokes.model

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
@Immutable
data class Joke(
    @PrimaryKey val id: String,
    val headline: String,
    val punchline: String,
    val type: String,
    val author: String,
    val date: Int,
    val NSFW: Boolean
) {
    companion object {
        fun mock() = Joke(
            id = "0",
            headline = "What do you call Dragon with no silver?",
            punchline = "A dron",
            type = "Silver",
            author = "unknown",
            date = 1000,
            NSFW = true
        )
    }
}