package com.example.mybilbo

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun Myform() {
    
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BilboForm() {
    var progresiones by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var isCustomValue by rememberSaveable { mutableStateOf(false) }

    Text(
        text = "",
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.displaySmall
    )

    OutlinedTextField(
        value = nombre,
        onValueChange = { nombre = it },
        label = { Text("Nombre") }
    )

    OutlinedTextField(
        value = progresiones,
        onValueChange = { progresiones = it },
        label = { Text("Repeticion Máxima (PR)") }
    )

    // Menú desplegable para elegir entre valor estándar y personalizado
    DropdownMenu(
        expanded = isCustomValue,
        onDismissRequest = { isCustomValue = false },
        modifier = Modifier
            .width(150.dp)
            .padding(top = 8.dp)
    ) {
        DropdownMenuItem(
            onClick = {
                isCustomValue = false
                // Establecer el valor estándar a 2.5
                progresiones = "2.5"
            }
        ) {
            Text("Valor Estándar (2.5)")
        }
        DropdownMenuItem(
            onClick = {
                isCustomValue = false
                // Puedes agregar lógica aquí para permitir al usuario ingresar un valor personalizado
                // progresiones = "Valor Personalizado"
            }
        ) {
            Text("Personalizado")
        }
    }

    // Mostrar un botón o un enlace para activar el menú desplegable
    Text(
        text = "Seleccionar Valor",
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .padding(top = 8.dp)
            .clickable {
                isCustomValue = !isCustomValue
            }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BilboForm() {
    var rmInicio by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var isCustomValue by rememberSaveable { mutableStateOf(false) }
    var progresiones by remember { mutableStateOf("") }



    Text(
        text = "",
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

    // Menú desplegable para elegir entre valor estándar y personalizado
    DropdownMenu(
        expanded = isCustomValue,
        onDismissRequest = { isCustomValue = false },
        modifier = Modifier
            .width(150.dp)
            .padding(top = 8.dp)
    ) {
        DropdownMenuItem(
            onClick = {
                isCustomValue = false
                // Establecer el valor estándar
                progresiones = "Valor Estándar"
            }
        ) {
            Text("Valor Estándar")
        }
        DropdownMenuItem(
            onClick = {
                isCustomValue = false
                // Puedes agregar lógica aquí para permitir al usuario ingresar un valor personalizado
                // rmInicio = "Valor Personalizado"
            }
        ) {
            Text("Personalizado")
        }
    }

    // Mostrar un botón o un enlace para activar el menú desplegable
    Text(
        text = "Seleccionar Valor",
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .padding(top = 8.dp)
            .clickable {
                isCustomValue = !isCustomValue
            }
    )
}


}



@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun MyPrev() {
    MyStructure()
}