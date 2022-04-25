package hu.bme.aut.dadjokes.mapping

import hu.bme.aut.dadjokes.model.dto.AuthorDTO
import hu.bme.aut.dadjokes.model.dto.JokeDTO
import hu.bme.aut.dadjokes.model.mapping.toJoke
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.*

@RunWith(JUnit4::class)
class JokeDTOMapping {
    @Test
    fun testDtoToDomain() {
        val dtoObject = JokeDTO(
            type = "type",
            setup = "setup",
            punchline = "punchline",
            _id = "jokeId",
            author = AuthorDTO(name = "name", id = "authorId"),
            approved = true,
            date = 123,
            NSFW = false
        )

        val mappedObject = dtoObject.toJoke()

        assertEquals("name", mappedObject.author)
        assertFalse(mappedObject.NSFW)
        assertEquals(123, mappedObject.date)
        assertEquals("setup", mappedObject.headline)
        assertEquals("punchline", mappedObject.punchline)
        assertEquals("jokeId", mappedObject.id)
        assertEquals("type", mappedObject.type)
        assertEquals(Date(123L), mappedObject.computedDate)
    }

    @Test
    fun testDtoToDomainMissingId() {
        val dtoObject = JokeDTO(
            type = "type",
            setup = "setup",
            punchline = "punchline",
            author = AuthorDTO(name = "name", id = "authorId"),
            approved = true,
            date = 123,
            NSFW = false
        )

        val mappedObject = dtoObject.toJoke()

        assertEquals("name", mappedObject.author)
        assertFalse(mappedObject.NSFW)
        assertEquals(123, mappedObject.date)
        assertEquals("setup", mappedObject.headline)
        assertEquals("punchline", mappedObject.punchline)
        assertEquals("", mappedObject.id)
        assertEquals("type", mappedObject.type)
        assertEquals(Date(123L), mappedObject.computedDate)
    }

    @Test
    fun testDtoToDomainMissingAuthor() {
        val dtoObject = JokeDTO(
            type = "type",
            setup = "setup",
            punchline = "punchline",
            _id = "jokeId",
            approved = true,
            date = 123,
            NSFW = false
        )

        val mappedObject = dtoObject.toJoke()

        assertEquals("", mappedObject.author)
        assertFalse(mappedObject.NSFW)
        assertEquals(123, mappedObject.date)
        assertEquals("setup", mappedObject.headline)
        assertEquals("punchline", mappedObject.punchline)
        assertEquals("jokeId", mappedObject.id)
        assertEquals("type", mappedObject.type)
        assertEquals(Date(123L), mappedObject.computedDate)
    }

    @Test
    fun testDtoToDomainMissingDate() {
        val dtoObject = JokeDTO(
            type = "type",
            setup = "setup",
            punchline = "punchline",
            _id = "jokeId",
            author = AuthorDTO(name = "name", id = "authorId"),
            approved = true,
            NSFW = false
        )

        val mappedObject = dtoObject.toJoke()

        assertEquals("name", mappedObject.author)
        assertFalse(mappedObject.NSFW)
        assertEquals(0, mappedObject.date)
        assertEquals("setup", mappedObject.headline)
        assertEquals("punchline", mappedObject.punchline)
        assertEquals("jokeId", mappedObject.id)
        assertEquals("type", mappedObject.type)
        assertEquals(Date(0L), mappedObject.computedDate)
    }

    @Test
    fun testDtoToDomainMissingNSFW() {
        val dtoObject = JokeDTO(
            type = "type",
            setup = "setup",
            punchline = "punchline",
            _id = "jokeId",
            author = AuthorDTO(name = "name", id = "authorId"),
            approved = true,
            date = 123
        )

        val mappedObject = dtoObject.toJoke()

        assertEquals("name", mappedObject.author)
        assertFalse(mappedObject.NSFW)
        assertEquals(123, mappedObject.date)
        assertEquals("setup", mappedObject.headline)
        assertEquals("punchline", mappedObject.punchline)
        assertEquals("jokeId", mappedObject.id)
        assertEquals("type", mappedObject.type)
        assertEquals(Date(123L), mappedObject.computedDate)
    }

    @Test
    fun testDtoToDomainMissingApproved() {
        val dtoObject = JokeDTO(
            type = "type",
            setup = "setup",
            punchline = "punchline",
            _id = "jokeId",
            author = AuthorDTO(name = "name", id = "authorId"),
            date = 123,
            NSFW = false
        )

        val mappedObject = dtoObject.toJoke()

        assertEquals("name", mappedObject.author)
        assertFalse(mappedObject.NSFW)
        assertEquals(123, mappedObject.date)
        assertEquals("setup", mappedObject.headline)
        assertEquals("punchline", mappedObject.punchline)
        assertEquals("jokeId", mappedObject.id)
        assertEquals("type", mappedObject.type)
        assertEquals(Date(123L), mappedObject.computedDate)
    }
}