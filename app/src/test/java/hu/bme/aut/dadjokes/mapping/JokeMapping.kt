package hu.bme.aut.dadjokes.mapping

import hu.bme.aut.dadjokes.model.dto.AuthorDTO
import hu.bme.aut.dadjokes.model.dto.JokeDTO
import hu.bme.aut.dadjokes.model.dto.JokeListResponseDTO
import hu.bme.aut.dadjokes.model.mapping.toJokes
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.*

@RunWith(JUnit4::class)
class JokeMapping {
    @Test
    fun testDtoToDomain() {
        val dtoObject = JokeListResponseDTO(
            success = true, body = arrayOf(
                JokeDTO(
                    type = "type",
                    setup = "setup",
                    punchline = "punchline",
                    _id = "jokeId",
                    author = AuthorDTO(name = "name", id = "authorId"),
                    approved = true,
                    date = 123,
                    NSFW = false
                )
            )
        )

        val mappedObject = dtoObject.toJokes()[0]

        assert(mappedObject.author == "name")
        assert(!mappedObject.NSFW)
        assert(mappedObject.date == 123)
        assert(mappedObject.headline == "setup")
        assert(mappedObject.punchline == "punchline")
        assert(mappedObject.id == "jokeId")
        assert(mappedObject.type == "type")
        assert(mappedObject.computedDate == Date(123L))
    }
}