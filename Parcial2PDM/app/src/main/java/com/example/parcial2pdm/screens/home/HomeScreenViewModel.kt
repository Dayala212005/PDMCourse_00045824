package com.example.parcial2pdm.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.parcial2pdm.Parcial2PDM
import com.example.parcial2pdm.data.repositorio.PlaceApiRepository
import com.example.parcial2pdm.data.repositorio.PlaceRepository
import com.example.parcial2pdm.data.repository.OptionRepository
import com.example.parcial2pdm.model.Place
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
class HomeViewModel(
    private val optionRepository: OptionRepository,
    private val questionId: Int
) : ViewModel() {

    val options: StateFlow<List<Place>> = optionRepository
        .getOptions(questionId)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    private val _selectedPlace = MutableStateFlow<Int?>(null)
    val selectedPlace = _selectedPlace.asStateFlow()

    fun selectPlace(placeId: Int) {
        _selectedPlace.value = placeId
    }

    companion object {
        fun provideFactory(questionId: Int) = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as Parcial2PDM
                HomeViewModel(
                    optionRepository = app.appProvider.provideOptionRepository(),
                    questionId = questionId
                )
            }
        }
    }
}