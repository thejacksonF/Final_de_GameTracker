package com.jorgeromo.androidbasicsclass.ui.secondpartialpdm1.homeSecondPartialPDM1.network

import com.jorgeromo.androidbasicsclass.ui.secondpartialpdm1.homeSecondPartialPDM1.view.GameProgress
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class GamesResponse(
    val games: List<GameProgress>
)

interface GameApiService {
    @GET("thejacksonF/8eaddcbd671699e06b782b6a7996112a/raw/be45ac2d9d8b2d70683ab418cb820a60b595053e/games.json")
    suspend fun getGames(): GamesResponse
}

object GameRetrofitClient {
    val gameApiService: GameApiService = Retrofit.Builder()
        .baseUrl("https://gist.githubusercontent.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GameApiService::class.java)
}