package ru.mavrinvladislav.jetpack.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import ru.mavrinvladislav.jetpack.data.remote.model.ResultDto

interface ApiService {

    @GET("aggs/ticker/AAPL/range/{timeframe}/2023-01-09/2025-01-01?adjusted=true&sort=desc&limit=50000&apiKey=uJ6eM7NKMHKAlKh4Bng6JOlr8K7AMLP0")
    suspend fun loadBars(
        @Path("timeframe")
        timeFrame: String
    ): Response<ResultDto>
}