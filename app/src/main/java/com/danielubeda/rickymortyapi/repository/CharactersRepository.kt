package com.danielubeda.rickymortyapi.repository

import com.danielubeda.rickymortyapi.model.CharacterResponse
import retrofit2.Response

interface CharactersRepository {
    suspend fun getCharacters(): Response<CharacterResponse>
}