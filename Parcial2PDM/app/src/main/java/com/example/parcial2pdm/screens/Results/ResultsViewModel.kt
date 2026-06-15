package com.example.parcial2pdm.screens.Results

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcial2pdm.data.repositorio.PlaceApiRepository
import com.example.parcial2pdm.data.repositorio.PlaceRepository
import com.example.parcial2pdm.model.Place
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class ResultsViewModel : ViewModel() {

    private val repository: PlaceRepository = PlaceApiRepository()

    private val _places = MutableStateFlow<List<Place>>(emptyList())
    val places = _places.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    fun loadResults() {
        viewModelScope.launch {

            _loading.value = true

            repository.getPlaces()
                .onSuccess {
                    _places.value = it.sortedByDescending { place ->
                        place.votes
                    }
                }
                .onFailure {
                    _error.value = it.message
                }

            _loading.value = false
        }
    }
}