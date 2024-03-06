package com.danielubeda.rickymortyapi.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danielubeda.rickymortyapi.model.Character
import com.danielubeda.rickymortyapi.network.ApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    private val _characters = MutableStateFlow<List<Character>>(emptyList())
    val characters: StateFlow<List<Character>> = _characters

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        viewModelScope.launch {
            val response = ApiClient.service.getCharacters()
            if (response.isSuccessful && response.body() != null) {
                _characters.value = response.body()!!.results
            } else {
                _characters.value = emptyList()
            }
        }
    }

    fun getCharacterById(id: Int): Character? {
        return _characters.value.find { it.id == id }
    }
}
