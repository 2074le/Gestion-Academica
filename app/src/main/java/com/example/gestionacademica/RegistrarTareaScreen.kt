package com.example.gestionacademica

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegistrarTareaScreen(
    volverInicio: () -> Unit
) {

    var titulo by remember {
        mutableStateOf("")
    }

    var materia by remember {
        mutableStateOf("")
    }

    var descripcion by remember {
        mutableStateOf("")
    }

    var fecha by remember {
        mutableStateOf("")
    }

    var hora by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Fondo)
            .padding(24.dp)
    ) {

        // ENCABEZADO
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = volverInicio
            ) {

                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Volver",
                    tint = Morado
                )
            }

            Text(
                text = "Nueva tarea",
                color = TextoOscuro,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        // TÍTULO
        OutlinedTextField(
            value = titulo,

            onValueChange = {
                titulo = it
            },

            modifier = Modifier.fillMaxWidth(),

            label = {
                Text("Nombre de la tarea")
            },

            singleLine = true,

            shape = RoundedCornerShape(16.dp)
        )

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        // MATERIA
        OutlinedTextField(
            value = materia,

            onValueChange = {
                materia = it
            },

            modifier = Modifier.fillMaxWidth(),

            label = {
                Text("Materia")
            },

            singleLine = true,

            shape = RoundedCornerShape(16.dp)
        )

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        // DESCRIPCIÓN
        OutlinedTextField(
            value = descripcion,

            onValueChange = {
                descripcion = it
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),

            label = {
                Text("Descripción")
            },

            shape = RoundedCornerShape(16.dp)
        )

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        // FECHA
        OutlinedTextField(
            value = fecha,

            onValueChange = {
                fecha = it
            },

            modifier = Modifier.fillMaxWidth(),

            label = {
                Text("Fecha de entrega")
            },

            placeholder = {
                Text("Ejemplo: 15/10/2026")
            },

            singleLine = true,

            shape = RoundedCornerShape(16.dp)
        )

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        // HORA
        OutlinedTextField(
            value = hora,

            onValueChange = {
                hora = it
            },

            modifier = Modifier.fillMaxWidth(),

            label = {
                Text("Hora")
            },

            placeholder = {
                Text("Ejemplo: 6:00 PM")
            },

            singleLine = true,

            shape = RoundedCornerShape(16.dp)
        )

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        // GUARDAR
        Button(
            onClick = {

                // Después conectaremos esto con la lista de tareas

                volverInicio()
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Morado
            ),

            shape = RoundedCornerShape(16.dp)
        ) {

            Text(
                text = "Guardar tarea",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}