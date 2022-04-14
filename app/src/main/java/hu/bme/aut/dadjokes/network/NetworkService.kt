package hu.bme.aut.dadjokes.network

import com.skydoves.sandwich.ApiResponse
import hu.bme.aut.dadjokes.model.Joke
import hu.bme.aut.dadjokes.model.dto.JokeListResponseDTO
import hu.bme.aut.dadjokes.model.dto.ResponseDTO
import retrofit2.http.*

interface NetworkService {
    @GET("random/joke")
    suspend fun getJokeList(@Query("count") count: String): ApiResponse<JokeListResponseDTO>

    @POST("joke")
    suspend fun createJoke(@Body joke: Joke): ApiResponse<ResponseDTO>

    @PUT("joke")
    suspend fun likeJoke(
        @Query("id") id: String,
        @Query("like") like: Boolean
    ): ApiResponse<ResponseDTO>

    @DELETE("joke")
    suspend fun deleteJoke(@Query("id") id: String): ApiResponse<ResponseDTO>
}