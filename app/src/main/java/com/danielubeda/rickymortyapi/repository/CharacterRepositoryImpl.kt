package com.danielubeda.rickymortyapi.repository

import com.danielubeda.rickymortyapi.model.CharacterResponse
import com.danielubeda.rickymortyapi.network.api.RickAndMortyService
import dagger.hilt.android.scopes.ActivityScoped
import retrofit2.Response
import javax.inject.Inject

@ActivityScoped
class CharacterRepositoryImpl @Inject constructor(
    private val service: RickAndMortyService
) : CharactersRepository{
    override suspend fun getCharacters(): Response<CharacterResponse> {
        return service.getCharacters()
    }
}