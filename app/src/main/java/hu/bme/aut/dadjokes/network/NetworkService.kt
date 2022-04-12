package hu.bme.aut.dadjokes.network

import com.skydoves.sandwich.ApiResponse
import hu.bme.aut.dadjokes.model.dto.JokeListResponseDTO
import retrofit2.http.*

interface NetworkService {
    @GET("random/joke")
    suspend fun getJokeList(@Query("count") count: String): ApiResponse<JokeListResponseDTO>

    @POST("joke")
    suspend fun createJoke(@Query("id") id: String): ApiResponse<Void>

    @PUT("joke")
    suspend fun likeJoke(@Query("id") id: String): ApiResponse<Void>

    @DELETE("joke")
    suspend fun deleteJoke(@Query("id") id: String): ApiResponse<Void>
}