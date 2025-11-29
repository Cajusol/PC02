package com.mcajusol.pc02.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("countries")
    suspend fun getCountries(): CountryResponse

    @GET("teams")
    suspend fun getTeamsByCountry(@Query("country") country: String )
            : TeamResponse

}