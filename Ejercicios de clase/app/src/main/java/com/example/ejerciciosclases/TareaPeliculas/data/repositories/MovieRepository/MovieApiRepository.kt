package com.example.ejerciciosclases.TareaPeliculas.data.repositories.MovieRepository

import com.example.ejerciciosclases.TareaPeliculas.data.api.KtorClient
import com.example.ejerciciosclases.TareaPeliculas.model.Movie
import com.example.ejerciciosclases.TareaPeliculas.data.api.Movies.GetMoviesResponseDto
import com.example.ejerciciosclases.TareaPeliculas.data.api.Movies.MovieDto
import com.example.ejerciciosclases.TareaPeliculas.data.api.Movies.toModel
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class MovieApiRepository : MovieRepository {
    override suspend fun getMovies(): List<Movie> {
        val response: GetMoviesResponseDto = KtorClient.client.get("movie/upcoming") {
            parameter("language", "es-ES")
            parameter("page", 1)
        }.body()

        return response.results.map { movieDto -> movieDto.toModel() }
    }

    override suspend fun getMovieById(id: Int): Movie? {
        val response: MovieDto = KtorClient.client.get("movie/$id") {
            parameter("language", "es-ES")
        }.body()

        return response.toModel()
    }
}