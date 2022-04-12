package hu.bme.aut.dadjokes.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hu.bme.aut.dadjokes.model.Joke

@Dao
interface JokeDao {
    @Query("SELECT * FROM Joke WHERE id = :id_")
    suspend fun getJoke(id_: String): Joke?

    @Query("SELECT * FROM Joke")
    suspend fun getJokeList(): List<Joke>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertJokeList(jokes: List<Joke>)
}
