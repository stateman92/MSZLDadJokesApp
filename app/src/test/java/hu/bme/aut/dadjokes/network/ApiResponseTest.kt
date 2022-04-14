package hu.bme.aut.dadjokes.network

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.getOrThrow
import hu.bme.aut.dadjokes.model.Joke
import hu.bme.aut.dadjokes.model.mapping.toJokes
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ApiResponseTest : ApiAbstract<NetworkService>() {
    private lateinit var service: NetworkService

    @Before
    fun init() {
        service = createService(NetworkService::class.java)
    }

    @Test
    fun exception() {
        val exception = Exception("foo")
        val apiResponse = ApiResponse.error<String>(exception)
        assertThat(apiResponse.message, `is`("foo"))
    }

    @Test
    fun testGetJokeList() = runBlocking {
        enqueueResponse("Jokes.json")
        val jokeList = service.getJokeList(count = "5").getOrThrow().toJokes()
        assertThat(jokeList.get(index = 0).id, `is`("60dd36610b83921d24207d9f"))
        assertThat(jokeList.get(index = 1).id, `is`("60dd3770d3008f40c3ca0468"))
        assertThat(
            jokeList.get(index = 1).headline,
            `is`("I told my girlfriend she'd get Sax lessons for her birthday")
        )
    }

    @Test
    fun testCreateJoke() = runBlocking {
        enqueueResponse(fileName = "OK.json")
        val response = service.createJoke(joke = Joke.mock()).getOrThrow()
        assertThat(response.response, `is`("OK"))
    }

    @Test
    fun testLikeJoke() = runBlocking {
        enqueueResponse(fileName = "OK.json")
        val response = service.likeJoke(id = Joke.mock().id, like = true).getOrThrow()
        assertThat(response.response, `is`("OK"))
    }

    @Test
    fun testDislikeJoke() = runBlocking {
        enqueueResponse(fileName = "OK.json")
        val response = service.likeJoke(id = Joke.mock().id, like = false).getOrThrow()
        assertThat(response.response, `is`("OK"))
    }

    @Test
    fun testDeleteJoke() = runBlocking {
        enqueueResponse(fileName = "OK.json")
        val response = service.deleteJoke(id = Joke.mock().id).getOrThrow()
        assertThat(response.response, `is`("OK"))
    }
}