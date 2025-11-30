package com.mcajusol.pc02.data.remote.api

data class ManoCartas(
    val success: String,
    val deck_id: String,
    val remaining: Int?,
    val shuffled: String,
)

data class ManoCartasResponse(
    val response: List<ManoCartas>
)