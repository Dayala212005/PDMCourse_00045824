package com.example.parcial2pdm.data.repositorio

import android.os.Build.VERSION_CODES.BASE
import com.example.parcial2pdm.data.api.KtorClient
import com.example.parcial2pdm.data.api.PlaceDto
import com.example.parcial2pdm.data.api.VoteRequestDto
import com.example.parcial2pdm.data.api.toPlace
import com.example.parcial2pdm.model.Place
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.contentType
import io.ktor.http.ContentType

class PlaceApiRepository : PlaceRepository {

    override suspend fun getPlaces(): Result<List<Place>> {
        return try {

            val response: List<PlaceDto> =
                KtorClient.client.get("https://qjcxdvfzyseuvezacxsd.supabase.co/functions/v1/rankeuca/options")
                    .body()

            Result.success(
                response.map { it.toPlace() }
            )

        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun votePlace(placeId: Int): Result<Unit> {
        return try {

            KtorClient.client.post("https://qjcxdvfzyseuvezacxsd.supabase.co/functions/v1/rankeuca/vote") {
                contentType(ContentType.Application.Json)

                setBody(
                    VoteRequestDto(
                        optionId = placeId
                    )
                )
            }

            Result.success(Unit)

        } catch (e: Exception) {

            println("ERROR DEL VOTO: ${e.message}")
            e.printStackTrace()

            Result.failure(e)
        }
    }

}