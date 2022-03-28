package hu.bme.aut.dadjokes.network

import com.skydoves.sandwich.ApiResponse
import hu.bme.aut.dadjokes.model.Joke
import retrofit2.http.GET

interface NetworkService {
    @GET("joke")
    suspend fun fetchJokeList(): ApiResponse<List<Joke>>
}