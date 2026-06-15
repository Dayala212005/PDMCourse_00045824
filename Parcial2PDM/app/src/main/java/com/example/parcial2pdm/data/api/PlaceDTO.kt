package com.example.parcial2pdm.data.api

import com.example.parcial2pdm.model.Place
import kotlinx.serialization.Serializable

@Serializable
data class PlaceDto(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val votes: Int
)

fun PlaceDto.toPlace(): Place {
    return Place(
        id = id,
        name = name,
        imageUrl = imageUrl,
        votes = votes
    )
}