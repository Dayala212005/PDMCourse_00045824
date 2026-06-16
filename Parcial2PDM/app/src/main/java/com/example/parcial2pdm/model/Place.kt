package com.example.parcial2pdm.model

import com.example.parcial2pdm.data.database.entities.PlaceOptionEntity

data class Place(
    val id: Int = 0,
    val name: String,
    val imageUrl: String,
    val questionId: Int
)

fun Place.toEntity(): PlaceOptionEntity {
    return PlaceOptionEntity(
        id = id,
        name = name,
        imageUrl = imageUrl,
        questionId = questionId,
    )
}