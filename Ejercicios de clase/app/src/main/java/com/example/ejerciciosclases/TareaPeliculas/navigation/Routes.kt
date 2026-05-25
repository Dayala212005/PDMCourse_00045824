package com.example.ejerciciosclases.TareaPeliculas.navigation


import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes : NavKey {
    @Serializable
    data object Home : Routes()


    @Serializable
    data class MovieDetail(val movieId: Int) : Routes()
}
