package com.example.parcial2pdm.data

import android.content.Context
import com.example.parcial2pdm.data.database.AppDatabase
import com.example.parcial2pdm.data.repository.OptionRepository
import com.example.parcial2pdm.data.repository.OptionRepositoryImpl

class AppProvider(context: Context) {

    private val appDatabase = AppDatabase.getDatabase(context)
    private val optionDao = appDatabase.optionDao()

    private val optionRepository: OptionRepository =
        OptionRepositoryImpl(optionDao)

    fun provideOptionRepository(): OptionRepository {
        return optionRepository
    }
}