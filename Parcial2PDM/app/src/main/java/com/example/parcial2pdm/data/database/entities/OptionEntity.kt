package com.example.parcial2pdm.data.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.parcial2pdm.model.Place

@Entity(
    tableName = "options",
    foreignKeys = [
        ForeignKey(
            entity = QuestionEntity::class,
            parentColumns = ["id"],
            childColumns = ["questionId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("questionId")]
)
data class PlaceOptionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val imageUrl: String,
    val questionId: Int,
)

fun PlaceOptionEntity.toModel(): Place {
    return Place(
        id = id,
        name = name,
        imageUrl = imageUrl,
        questionId = questionId,
    )
}

fun Place.toEntity(): PlaceOptionEntity {
    return PlaceOptionEntity(
        id = id,
        name = name,
        imageUrl = imageUrl,
        questionId = questionId,
    )
}