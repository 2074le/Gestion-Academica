package com.example.gestionacademica

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PlanEstudioScreen(
    volverInicio: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Fondo)
    ) {

        // ENCABEZADO
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 24.dp,
                    top = 25.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = { volverInicio() }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Volver",
                    tint = Morado
                )
            }

            Column {
                Text(
                    text = "Plan de estudio",
                    color = TextoOscuro,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Organiza tu día 📚",
                    color = Gris,
                    fontSize = 14.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // MENSAJE
            item {

                Text(
                    text = "Aquí tienes tus sesiones de estudio",
                    color = TextoOscuro,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // PRIMERA SESIÓN
            item {

                SesionEstudioCard(
                    materia = "Programación Web",
                    horario = "10:00 AM - 11:00 AM",
                    descripcion = "Repasar HTML y CSS"
                )
            }

            // SEGUNDA SESIÓN
            item {

                SesionEstudioCard(
                    materia = "Bases de Datos",
                    horario = "2:00 PM - 3:00 PM",
                    descripcion = "Estudiar consultas SQL"
                )
            }

            // TERCERA SESIÓN
            item {

                SesionEstudioCard(
                    materia = "Programación Orientada a Objetos",
                    horario = "5:00 PM - 6:00 PM",
                    descripcion = "Repasar clases y objetos"
                )
            }

            // BOTÓN
            item {

                Button(
                    onClick = {
                        // Más adelante agregaremos
                        // la creación de una sesión
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Morado
                    ),
                    shape = RoundedCornerShape(16.dp)
                ) {

                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null
                    )

                    Spacer(
                        modifier = Modifier.width(8.dp)
                    )

                    Text(
                        text = "Nueva sesión",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(
                    modifier = Modifier.height(20.dp)
                )
            }
        }
    }
}


// TARJETA DE SESIÓN

@Composable
fun SesionEstudioCard(
    materia: String,
    horario: String,
    descripcion: String
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // ICONO
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(
                        color = MoradoClaro,
                        shape = RoundedCornerShape(14.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = Icons.Default.MenuBook,
                    contentDescription = null,
                    tint = Morado
                )
            }

            Spacer(
                modifier = Modifier.width(15.dp)
            )

            // INFORMACIÓN
            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = materia,
                    color = TextoOscuro,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = horario,
                    color = Morado,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(5.dp)
                )

                Text(
                    text = descripcion,
                    color = Gris,
                    fontSize = 13.sp
                )
            }
        }
    }
}