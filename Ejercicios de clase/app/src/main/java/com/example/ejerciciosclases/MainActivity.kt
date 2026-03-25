package com.example.ejerciciosclases

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ejerciciosclases.ui.theme.EjerciciosClasesTheme
import com.example.ejerciciosclases.clase23_3.CuadranteCompose
import com.example.ejerciciosclases.clase23_3.ArticuloCompose
import com.example.ejerciciosclases.clase23_3.AdministradorTareas

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjerciciosClasesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AdministradorTareas(modifier = Modifier)
                    //CuadranteCompose(modifier = Modifier)
                    //ArticuloCompose(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EjerciciosClasesTheme {
        Greeting("Android")
    }
}