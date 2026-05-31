package com.example.ejerciciosclases.POST.data.api.Post

import kotlinx.serialization.Serializable

@Serializable
data class CreatePostRequestDto(
    val title: String,
    val body: String,
    val userId: Int,
)
@Serializable
data class PostPostResponseDTO(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
) {

}