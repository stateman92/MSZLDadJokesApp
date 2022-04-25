package hu.bme.aut.dadjokes.persistence

import hu.bme.aut.dadjokes.MockTestUtil.mockJokeList
import hu.bme.aut.dadjokes.model.Joke
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
class JokeDaoTest : LocalDatabase() {
    private lateinit var jokeDao: JokeDao

    @Before
    override fun initDB() {
        super.initDB()
        jokeDao = db.jokeDao()
    }

    @Test
    fun insertJokeListTest() = runBlocking {
        val mockDataList = mockJokeList()
        jokeDao.insertJokeList(mockDataList)

        val jokeListInDb = jokeDao.getJokeList()
        assertThat(jokeListInDb.toString(), `is`(mockDataList.toString()))

        val mockData = Joke.mock()
        assertThat(jokeListInDb.first().toString(), `is`(mockData.toString()))
    }

    @Test
    fun getJokeTest() = runBlocking {
        val mockData = Joke.mock()
        jokeDao.insertJokeList(listOf(mockData))

        val jokeInDb = jokeDao.getJoke(mockData.id)
        assertThat(jokeInDb.toString(), `is`(mockData.toString()))
    }

    @Test
    fun getJokeListTest() = runBlocking {
        val jokeListInDb = jokeDao.getJokeList()
        assertThat(jokeListInDb.toString(), `is`(emptyList<Joke>().toString()))
    }

    @Test
    fun insertJokeListAndGetJokeListTest() = runBlocking {
        val jokeListInDbBeforeInsert = jokeDao.getJokeList()
        assertThat(jokeListInDbBeforeInsert.toString(), `is`(emptyList<Joke>().toString()))

        val mockDataList = mockJokeList()
        jokeDao.insertJokeList(mockDataList)

        val jokeListInDbAfterInsert = jokeDao.getJokeList()
        assertThat(jokeListInDbAfterInsert.toString(), `is`(mockDataList.toString()))
    }
}