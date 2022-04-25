package hu.bme.aut.dadjokes.model

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

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
            id = "60dd36a777fa33b5b73bc468",
            headline = "Everyone told me smoking kills, I had no idea how fast.",
            punchline = "My dad went to get his first pack of cigarettes ever and I never saw him again.",
            type = "idea",
            author = "unknown",
            date = 1618108661,
            NSFW = false
        )
    }

    val computedDate get() = Date(date.toLong())

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Joke

        return id == other.id
    }
}