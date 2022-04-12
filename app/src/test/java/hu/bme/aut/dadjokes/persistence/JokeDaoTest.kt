package hu.bme.aut.dadjokes.persistence

import org.hamcrest.CoreMatchers.`is`
import hu.bme.aut.dadjokes.MockTestUtil.mockJokeList
import hu.bme.aut.dadjokes.model.Joke
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
class JokeDaoTest : LocalDatabase() {
    private lateinit var posterDao: JokeDao

    @Before
    fun init() {
        posterDao = db.jokeDao()
    }

    @Test
    fun insertAndLoadPosterListTest() = runBlocking {
        val mockDataList = mockJokeList()
        posterDao.insertJokeList(mockDataList)

        val loadFromDB = posterDao.getJokeList()
        MatcherAssert.assertThat(loadFromDB.toString(), `is`(mockDataList.toString()))

        val mockData = Joke.mock()
        MatcherAssert.assertThat(loadFromDB[0].toString(), `is`(mockData.toString()))
    }
}