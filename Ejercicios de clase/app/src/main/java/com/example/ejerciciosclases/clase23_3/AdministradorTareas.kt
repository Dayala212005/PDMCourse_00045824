package com.example.ejerciciosclases.clase23_3

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejerciciosclases.R

@Composable
fun AdministradorTareas(modifier: Modifier) {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier) {
            Image(
                painter = painterResource(id = R.drawable.ic_task_completed),
                contentDescription = "Check"
            )
        }
        Box(modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)) {
            Text(text = stringResource(id = R.string.ATC ),
                fontWeight = FontWeight.Bold)
        }
        Box(modifier = Modifier) {
            Text(text = stringResource(id = R.string.NW),
            fontSize = 16.sp
            )
        }
    }
}

@Preview (showBackground = true)
@Composable
fun ATPreview() {
    AdministradorTareas(modifier = Modifier)
}