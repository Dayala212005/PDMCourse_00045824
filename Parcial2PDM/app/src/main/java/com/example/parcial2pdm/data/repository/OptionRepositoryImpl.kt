package com.example.parcial2pdm.data.repository

import com.example.parcial2pdm.data.database.dao.OptionDao
import com.example.parcial2pdm.data.database.entities.toEntity
import com.example.parcial2pdm.data.database.entities.toModel
import com.example.parcial2pdm.model.Place
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OptionRepositoryImpl(
    private val optionDao: OptionDao
) : OptionRepository {

    override fun getOptions(): Flow<List<Place>> {
        return optionDao.getAllOptions().map { entities ->
            entities.map { it.toModel() }
        }
    }

    override suspend fun addOption(option: Place) {
        optionDao.insertOption(option.toEntity())
    }

    override suspend fun deleteOption(option: Place) {
        optionDao.deleteOption(option.toEntity())
    }
}