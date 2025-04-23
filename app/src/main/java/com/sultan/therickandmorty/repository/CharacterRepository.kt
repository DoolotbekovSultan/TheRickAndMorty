package com.sultan.therickandmorty.repository

import com.sultan.therickandmorty.model.core.RetrofitClient

class CharacterRepository {
    suspend fun getCharacter() = RetrofitClient.characterService.getCharacter()
}