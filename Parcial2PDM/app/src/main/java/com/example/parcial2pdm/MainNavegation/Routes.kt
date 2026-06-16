package com.example.parcial2pdm.MainNavegation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class Routes : NavKey {

    @Serializable
    data object Questions : Routes()

    @Serializable
    data class Home(val questionId: Int) : Routes()

    @Serializable
    data class Options(val questionId: Int) : Routes()
}
