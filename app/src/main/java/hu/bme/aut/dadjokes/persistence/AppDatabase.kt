package hu.bme.aut.dadjokes.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import hu.bme.aut.dadjokes.model.Joke

@Database(entities = [Joke::class], version = 1, exportSchema = true)
abstract class AppDatabase: RoomDatabase() {

    abstract fun jokeDao(): JokeDao
}