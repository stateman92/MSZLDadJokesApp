package hu.bme.aut.dadjokes.mapping

import hu.bme.aut.dadjokes.model.dto.AuthorDTO
import hu.bme.aut.dadjokes.model.dto.JokeDTO
import hu.bme.aut.dadjokes.model.dto.JokeListResponseDTO
import hu.bme.aut.dadjokes.model.mapping.toJokes
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.*

@RunWith(JUnit4::class)
class JokeListResponseDTOMapping {
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

        val mappedObject = dtoObject.toJokes().first()

        assertEquals("name", mappedObject.author)
        assertFalse(mappedObject.NSFW)
        assertEquals(123, mappedObject.date)
        assertEquals("setup", mappedObject.headline)
        assertEquals("punchline", mappedObject.punchline)
        assertEquals("jokeId", mappedObject.id)
        assertEquals("type", mappedObject.type)
        assertEquals(Date(123L), mappedObject.computedDate)
    }

    @Test(expected = NoSuchElementException::class)
    fun testDtoToDomainEmptyResponse() {
        val dtoObject = JokeListResponseDTO(success = true, body = arrayOf())

        dtoObject.toJokes().first()
    }
}