package com.example.parcial2pdm.data.repository

import com.example.parcial2pdm.data.database.dao.QuestionDao
import com.example.parcial2pdm.data.database.entities.QuestionEntity
import com.example.parcial2pdm.data.database.entities.toModel
import com.example.parcial2pdm.model.Question
import com.example.parcial2pdm.model.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class QuestionRepositoryImpl(
    private val questionDao: QuestionDao
) : QuestionRepository {

    override fun getQuestions(): Flow<List<Question>> {
        return questionDao.getQuestionsWithOptions().map { list ->
            list.map { it.toModel() }
        }
    }

    override suspend fun addQuestion(title: String) {
        questionDao.insertQuestion(QuestionEntity(title = title))
    }

    override suspend fun deleteQuestion(question: Question) {
        questionDao.deleteQuestion(question.toEntity())
    }
}