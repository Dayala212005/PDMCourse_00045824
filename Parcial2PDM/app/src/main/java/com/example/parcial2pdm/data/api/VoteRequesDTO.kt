package com.example.parcial2pdm.data.api

import kotlinx.serialization.Serializable
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

@Serializable
data class VoteRequestDto(
    val optionId: Int
)

