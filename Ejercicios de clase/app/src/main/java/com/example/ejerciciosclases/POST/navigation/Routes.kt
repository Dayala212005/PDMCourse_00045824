package com.example.ejerciciosclases.POST.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes : NavKey {
    @Serializable
    data object View : Routes()
    @Serializable
    data object Create : Routes()
}