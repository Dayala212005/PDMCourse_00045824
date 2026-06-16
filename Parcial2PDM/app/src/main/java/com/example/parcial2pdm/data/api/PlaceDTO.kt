package com.example.parcial2pdm.data.api

import com.example.parcial2pdm.model.Place
import com.example.parcial2pdm.model.Question
import kotlinx.serialization.Serializable

@Serializable
data class PlaceDto(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val questionId: Int,
)

fun PlaceDto.toPlace(): Place {
    return Place(
        id = id,
        name = name,
        imageUrl = imageUrl,
        questionId = questionId,
    )
}