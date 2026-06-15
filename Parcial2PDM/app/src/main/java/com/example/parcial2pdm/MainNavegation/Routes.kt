package com.example.parcial2pdm.MainNavegation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes : NavKey {
    @Serializable
    data object Home : Routes()

    @Serializable
    data object Results : Routes()

    @Serializable
    data object Options : Routes()
}
