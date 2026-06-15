package com.example.parcial2pdm.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.parcial2pdm.model.Place

@Entity(tableName = "options")
data class PlaceOptionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val imageUrl: String,
)

fun PlaceOptionEntity.toModel(): Place {
    return Place(
        id = id,
        name = name,
        imageUrl = imageUrl,
    )
}

fun Place.toEntity(): PlaceOptionEntity {
    return PlaceOptionEntity(
        id = id,
        name = name,
        imageUrl = imageUrl,
    )
}