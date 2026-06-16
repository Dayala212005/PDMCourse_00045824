package com.example.parcial2pdm.data.database

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.parcial2pdm.Parcial2PDM
import com.example.parcial2pdm.data.repository.QuestionRepository
import com.example.parcial2pdm.model.Place
import com.example.parcial2pdm.model.Question
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


class QuestionViewModel(
    private val questionRepository: QuestionRepository,
): ViewModel() {
    val questions : StateFlow<List<Question>> =
        questionRepository.getQuestions()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )

    fun addQuestion(title: String) {
        viewModelScope.launch {
            questionRepository.addQuestion(title)
        }
    }

    fun deleteOption(question: Question) {
        viewModelScope.launch {
            questionRepository.deleteQuestion(question)
        }
    }

    companion object {
        fun provideFactory() = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as Parcial2PDM
                QuestionViewModel(app.appProvider.provideQuestionRepository())
            }
        }
    }
}