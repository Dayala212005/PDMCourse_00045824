package com.example.ejerciciosclases.TareaPeliculas.screens.MovieList


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ejerciciosclases.TareaPeliculas.data.repositories.MovieRepository.MovieApiRepository
import com.example.ejerciciosclases.TareaPeliculas.data.repositories.MovieRepository.MovieRepository
import com.example.ejerciciosclases.TareaPeliculas.model.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieListViewModel : ViewModel() {
    private val movieRepository: MovieRepository = MovieApiRepository()
    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies = _movies.asStateFlow()

    private val _loading = MutableStateFlow<Boolean>(false)
    val loading = _loading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()


    init {
        loadMovies()
    }

    fun loadMovies() {
        viewModelScope.launch {
            _loading.value = true
            movieRepository.getMovies()
                .onSuccess { movies ->
                    _movies.value = movies
                    _error.value = null
                }
                .onFailure { error ->
                    _error.value = error.message
                }
            _loading.value = false
        }
    }
}