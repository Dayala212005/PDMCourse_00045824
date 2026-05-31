package com.example.ejerciciosclases.TareaPeliculas.screens.MovieList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ejerciciosclases.TareaPeliculas.componentes.AppScaffold
import com.example.ejerciciosclases.TareaPeliculas.componentes.MovieItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieListScreen(
    navigateToDetail: (Int) -> Unit,
    viewModel: MovieListViewModel = viewModel()
) {

    val movies by viewModel.movies.collectAsState()
    val loading by viewModel.loading.collectAsState()
    val error by viewModel.error.collectAsState()

    if (loading) {
        AppScaffold(title = "Movies") { padding ->
            CircularProgressIndicator(modifier = Modifier.padding(padding))
        }
        return
    }

    if (error != null) {
        AppScaffold(title = "Movies") { padding ->
            Column(modifier = Modifier.padding(padding).fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Text(
                    text = error!!,
                    modifier = Modifier.padding(padding)
                )
                Button(onClick = { viewModel.loadMovies() }) {
                    Text(text = "Reintentar")
                }
            }
        }
        return
    }

    AppScaffold(title = "Movies") { padding ->
        PullToRefreshBox(
            modifier = Modifier.fillMaxWidth(),
            onRefresh = { viewModel.loadMovies() },
            isRefreshing = loading
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
            ) {
                items(movies) { movie ->
                    MovieItem(
                        movie = movie,
                        onClick = { navigateToDetail(movie.id) }
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }

    }
}
