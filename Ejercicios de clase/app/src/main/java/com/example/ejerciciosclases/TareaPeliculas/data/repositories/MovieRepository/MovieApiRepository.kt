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
    override suspend fun getMovies(): Result<List<Movie>> {
        try {
            val response: GetMoviesResponseDto = KtorClient.client.get("movie/upcoming") {
                parameter("language", "es-ES")
                parameter("page", 1)
            }.body()

            return Result.success(response.results.map { movieDto -> movieDto.toModel() })
        } catch (e: Exception) {
            return Result.failure(e)
        }

    }

    override suspend fun getMovieById(id: Int): Result<Movie> {
        try {
            val response: MovieDto = KtorClient.client.get("movie/$id") {
                parameter("language", "es-ES")
            }.body()

            return Result.success(response.toModel())
        } catch (e: Exception) {
            return Result.failure(e)
        }

    }
}