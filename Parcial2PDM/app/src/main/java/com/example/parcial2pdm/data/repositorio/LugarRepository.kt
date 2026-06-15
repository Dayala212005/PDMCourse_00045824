package com.example.parcial2pdm.data.repositorio

import com.example.parcial2pdm.model.Place


interface PlaceRepository{
    suspend fun getPlaces(): Result<List<Place>>

    suspend fun votePlace(placeId: Int): Result<Unit>
}