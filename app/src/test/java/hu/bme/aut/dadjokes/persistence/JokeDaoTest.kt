package hu.bme.aut.dadjokes.persistence

import hu.bme.aut.dadjokes.MockTestUtil.mockJokeList
import hu.bme.aut.dadjokes.model.Joke
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert
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
    fun init() {
        jokeDao = db.jokeDao()
    }

    @Test
    fun insertJokeListTest() = runBlocking {
        val mockDataList = mockJokeList()
        jokeDao.insertJokeList(mockDataList)

        val jokeListInDb = jokeDao.getJokeList()
        MatcherAssert.assertThat(jokeListInDb.toString(), `is`(mockDataList.toString()))

        val mockData = Joke.mock()
        MatcherAssert.assertThat(jokeListInDb[0].toString(), `is`(mockData.toString()))
    }

    @Test
    fun getJokeTest() = runBlocking {
        val mockData = Joke.mock()
        jokeDao.insertJokeList(listOf(mockData))

        val jokeInDb = jokeDao.getJoke(mockData.id)
        MatcherAssert.assertThat(jokeInDb.toString(), `is`(mockData.toString()))
    }

    @Test
    fun getJokeListTest() = runBlocking {
        val jokeListInDb = jokeDao.getJokeList()
        MatcherAssert.assertThat(
            jokeListInDb.toString(),
            `is`(emptyList<Joke>().toString())
        )
    }

    @Test
    fun insertJokeListAndGetJokeListTest() = runBlocking {
        val jokeListInDbBeforeInsert = jokeDao.getJokeList()
        MatcherAssert.assertThat(
            jokeListInDbBeforeInsert.toString(),
            `is`(emptyList<Joke>().toString())
        )

        val mockDataList = mockJokeList()
        jokeDao.insertJokeList(mockDataList)

        val jokeListInDbAfterInsert = jokeDao.getJokeList()
        MatcherAssert.assertThat(jokeListInDbAfterInsert.toString(), `is`(mockDataList.toString()))
    }
}