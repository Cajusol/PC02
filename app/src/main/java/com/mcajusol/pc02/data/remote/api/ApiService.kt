package com.mcajusol.pc02.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {




        @GET("new/shuffle/?deck_count=1")
        suspend fun getManoCartas(): ManoCartas

        @GET("/{{deck_id}}/draw/?count={{count_of_cards}})")
        suspend fun getManoCartas2(): ManoCartas


}