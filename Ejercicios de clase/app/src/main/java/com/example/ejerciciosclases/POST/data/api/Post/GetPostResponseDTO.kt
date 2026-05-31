package com.example.ejerciciosclases.POST.data.api.Post

import kotlinx.serialization.Serializable

@Serializable
data class GetPostResponseDTO(
    val results: List<PostDTO>
)