package com.sultan.therickandmorty.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sultan.therickandmorty.model.model.CharacterResponse
import com.sultan.therickandmorty.repository.CharacterRepository
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    private val repository = CharacterRepository()

    private val _character = MutableLiveData<CharacterResponse?>()
    val character : LiveData<CharacterResponse?> = _character

    fun getCharacter() {
        viewModelScope.launch {
            try {
                val response = repository.getCharacter()
                Log.e("TEST", "Success: ${response?.results?.size} characters loaded")
                Log.e("ololo", "getCharacter: Response = $response")
                _character.value = response
            } catch (e : Exception) {
                Log.e("TEST", "Error: ${e.localizedMessage}", e)
                Log.e("ololo", "getCharacter: Error = ${e.message}")
                e.printStackTrace()
            }
        }
    }

}