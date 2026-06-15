package com.example.parcial2pdm.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcial2pdm.componentes.PlaceItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navigateToResults: () -> Unit, viewModel: HomeViewModel = viewModel(),
               navigateToOptions : () -> Unit) {

    val places by viewModel.places.collectAsState()
    val loading by viewModel.loading.collectAsState()
    val error by viewModel.error.collectAsState()
    val selectedPlace by viewModel.selectedPlace.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadPlaces()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("RankeUca - Vota")
                },
                actions = {
                    IconButton(onClick = { navigateToOptions() }) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Administrar opciones"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->

        when {
            loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            error != null -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {
                    Text(error ?: "Error")
                }
            }

            else -> {
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                ) {

                    LazyColumn(
                        modifier = Modifier.weight(1f)
                    ) {

                        items(places) { place ->

                            PlaceItem(
                                place = place,
                                selected = selectedPlace == place.id,
                                onClick = {
                                    viewModel.votePlace(place.id)
                                }
                            )
                        }
                    }

                    Button(onClick = {navigateToResults()},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text("Ir a resultados")
                    }
                }
            }
        }
    }
}
