package com.sultan.therickandmorty.model.service

import com.sultan.therickandmorty.model.model.CharacterResponse
import retrofit2.http.GET

interface CharacterService {
    @GET("character")
    suspend fun getCharacter() : CharacterResponse?
}