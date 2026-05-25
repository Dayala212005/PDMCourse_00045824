package com.example.ejerciciosclases.TareaPeliculas.data.repositories.MovieRepository

import com.example.ejerciciosclases.TareaPeliculas.model.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>
    suspend fun getMovieById(id: Int): Movie?
}