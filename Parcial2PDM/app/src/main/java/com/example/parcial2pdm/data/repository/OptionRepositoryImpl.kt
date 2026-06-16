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

    override fun getOptions(questionId: Int): Flow<List<Place>> {
        return optionDao.getOptionsForQuestion(questionId).map { entities ->
            entities.map { it.toModel() }
        }
    }

    override suspend fun addOption(name: String, imageUrl: String, questionId: Int) {
        val option = Place(name = name, imageUrl = imageUrl, questionId = questionId)
        optionDao.insertOption(option.toEntity())
    }

    override suspend fun deleteOption(option: Place) {
        optionDao.deleteOption(option.toEntity())
    }
}