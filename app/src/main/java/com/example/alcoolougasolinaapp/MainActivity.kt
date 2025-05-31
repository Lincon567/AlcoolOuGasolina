package com.example.alcoolougasolinaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcoolougasolinaapp.ui.theme.AlcoolOuGasolinaAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlcoolOuGasolinaAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AlcoolOuGasolinaScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun AlcoolOuGasolinaScreen(modifier: Modifier = Modifier) {
    var precoAlcool by remember { mutableStateOf("") }
    var precoGasolina by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Álcool ou Gasolina?",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = precoAlcool,
            onValueChange = {
                precoAlcool = it.replace(",", ".")
            },
            label = { Text("Preço do Álcool (ex: 5.49)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = precoGasolina,
            onValueChange = {
                precoGasolina = it.replace(",", ".")
            },
            label = { Text("Preço da Gasolina (ex: 7.29)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                val alcool = precoAlcool.toDoubleOrNull()
                val gasolina = precoGasolina.toDoubleOrNull()

                if (alcool != null && gasolina != null && gasolina > 0) {
                    val proporcao = alcool / gasolina
                    resultado = if (proporcao <= 0.7) {
                        "Abasteça com Álcool"
                    } else {
                        "Abasteça com Gasolina"
                    }
                } else {
                    resultado = "Por favor, insira valores válidos."
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular")
        }

        Spacer(modifier = Modifier.height(24.dp))

        if (resultado.isNotEmpty()) {
            Text(
                text = resultado,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlcoolOuGasolinaScreenPreview() {
    AlcoolOuGasolinaAppTheme {
        AlcoolOuGasolinaScreen()
    }
}