package com.danielubeda.rickymortyapi.di

import com.danielubeda.rickymortyapi.network.ApiClient
import com.danielubeda.rickymortyapi.repository.CharacterRepositoryImpl
import com.danielubeda.rickymortyapi.repository.CharactersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @Provides
    fun provideCharactersRepository(): CharactersRepository {
        return CharacterRepositoryImpl(ApiClient.service)
    }

}
