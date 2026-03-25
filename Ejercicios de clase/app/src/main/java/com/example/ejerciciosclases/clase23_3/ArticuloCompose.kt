package com.example.ejerciciosclases.clase23_3

import androidx.activity.result.PickVisualMediaRequest
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.ejerciciosclases.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejerciciosclases.ui.theme.EjerciciosClasesTheme


@Composable
fun ArticuloCompose(modifier: Modifier) {
    Column(modifier = Modifier) {
        Box(modifier = Modifier) {
            Image(
                painter = painterResource(id = R.drawable.bg_compose_background),
                contentDescription = "Imagen del artículo"
            )
        }
        Box(modifier = Modifier.padding(16.dp)) {
            Text(text = stringResource(id = R.string.text_1),
                fontSize = 24.sp)
        }
        Box(modifier = Modifier.padding(16.dp)) {
            Text(text = stringResource(R.string.text_2),
                textAlign = TextAlign.Justify)
        }
        Box(modifier = Modifier.padding(16.dp)) {
            Text(text = stringResource(R.string.text_3),
                textAlign = TextAlign.Justify)
        }
    }
}

@Preview (showBackground = true)
@Composable
fun ACPreview() {
        ArticuloCompose(modifier = Modifier)

}