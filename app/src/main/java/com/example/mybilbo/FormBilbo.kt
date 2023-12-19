package com.example.mybilbo

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@RequiresApi(Build.VERSION_CODES.O)
fun MyStructure() {
    var nombre by remember { mutableStateOf("") }
    // Estructura principal de la aplicación con barra superior
    Scaffold(
        topBar = {
            TopAppBar(
                // Configuración de colores para la barra superior
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                ),
                // Título de la barra superior
                title = {
                    Text(
                        text = "Primer Ciclo $nombre",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            )
        }
    ) { innerPadding ->
        // Contenido principal dentro de un Column
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(25.dp)
                .padding(innerPadding)
        ) {
            // Llamada al formulario principal
            BilboForm()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BilboForm() {
    var rmInicio by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var progresiones by rememberSaveable { mutableStateOf("2.5") }
    var isCustomValue by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }

    Text(
        text = "Formulario Bilbo",
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.displaySmall
    )

    OutlinedTextField(
        value = nombre,
        onValueChange = { nombre = it },
        label = { Text("Nombre") }
    )

    OutlinedTextField(
        value = rmInicio,
        onValueChange = { rmInicio = it },
        label = { Text("Repeticion Máxima (PR)") }
    )

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        OutlinedTextField(
            readOnly = !isCustomValue,
            value = progresiones,
            onValueChange = { progresiones = it },
            label = { Text("Progresiones") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text("Estándar 2.5") },
                onClick = {
                    progresiones = "2.5"
                    expanded = false
                    isCustomValue = false
                }
            )
            DropdownMenuItem(
                text = { Text("Personalizado") },
                onClick = {
                    // Para los valores personalizados, mantener el menú abierto
                    // y permitir que el usuario escriba su valor.
                    expanded = false
                    isCustomValue = true
                }
            )
        }
    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun MyPrev() {
    MaterialTheme {
        MyStructure()
    }
}
