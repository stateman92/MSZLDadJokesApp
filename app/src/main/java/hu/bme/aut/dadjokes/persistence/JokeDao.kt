package hu.bme.aut.dadjokes.persistence

import androidx.room.Dao
import androidx.room.Query
import hu.bme.aut.dadjokes.model.Joke

@Dao
interface JokeDao {
    @Query("SELECT * FROM Joke WHERE id = :id_")
    suspend fun getJoke(id_: Long): Joke?

    @Query("SELECT * FROM Joke")
    suspend fun getJokeList(): List<Joke>
}
