package hu.bme.aut.dadjokes.mapping

import hu.bme.aut.dadjokes.model.dto.AuthorDTO
import hu.bme.aut.dadjokes.model.mapping.toAuthor
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class AuthorDTOMapping {
    @Test
    fun testDtoToDomain() {
        val dtoObject = AuthorDTO(name = "name", id = "authorId")

        val mappedObject = dtoObject.toAuthor()

        assertEquals("name", mappedObject)
    }
}