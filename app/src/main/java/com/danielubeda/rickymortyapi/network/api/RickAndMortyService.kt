package com.danielubeda.rickymortyapi.network.api

import com.danielubeda.rickymortyapi.model.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET

interface RickAndMortyService {
    @GET("character")
    suspend fun getCharacters(): Response<CharacterResponse>
}
