package com.example.parcial2pdm.data.repository

import com.example.parcial2pdm.model.Place
import kotlinx.coroutines.flow.Flow

interface OptionRepository {
    fun getOptions(): Flow<List<Place>>
    suspend fun addOption(option: Place)
    suspend fun deleteOption(option: Place)
}