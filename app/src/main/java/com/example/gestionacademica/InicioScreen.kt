package com.example.gestionacademica

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InicioScreen(
    irRegistrarTarea: () -> Unit,
    irVark: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Fondo)
    ) {

        // Encabezado
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 25.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column {

                Text(
                    text = "Hola",
                    color = Gris,
                    fontSize = 15.sp
                )

                Text(
                    text = "¡Vamos a estudiar!",
                    color = TextoOscuro,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            IconButton(
                onClick = {
                    // Próximamente notificaciones
                }
            ) {

                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notificaciones",
                    tint = Morado
                )
            }
        }

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),

            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {

            // META DEL DÍA
            item {

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Morado
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        Text(
                            text = "Meta de hoy 🎯",
                            color = androidx.compose.ui.graphics.Color.White,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Text(
                            text = "Estudia 2 horas hoy",
                            color = androidx.compose.ui.graphics.Color.White,
                            fontSize = 14.sp
                        )

                        Spacer(
                            modifier = Modifier.height(15.dp)
                        )

                        LinearProgressIndicator(
                            progress = { 0.5f },

                            modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp),

                            color = Verde,
                            trackColor = androidx.compose.ui.graphics.Color.White.copy(
                                alpha = 0.3f
                            )
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Text(
                            text = "1 de 2 horas completadas",
                            color = androidx.compose.ui.graphics.Color.White,
                            fontSize = 13.sp
                        )
                    }
                }
            }

            item {

                Card(
                    onClick = { irVark() },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MoradoClaro
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        Text(
                            text = "🧠 Descubre tu estilo de aprendizaje",
                            color = MoradoOscuro,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Realiza el test VARK y descubre cómo prefieres aprender.",
                            color = Gris,
                            fontSize = 14.sp
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "Hacer test →",
                            color = Morado,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            // TÍTULO DE TAREAS
            item {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Mis tareas",
                        color = TextoOscuro,
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold
                    )

                    TextButton(
                        onClick = irRegistrarTarea
                    ) {

                        Text(
                            text = "Ver todas",
                            color = Morado
                        )
                    }
                }
            }

            // TAREA DE EJEMPLO
            item {

                TareaCard(
                    titulo = "Trabajo de Programación",
                    materia = "Programación Web",
                    fecha = "Hoy · 6:00 PM"
                )
            }

            item {

                TareaCard(
                    titulo = "Estudiar para parcial",
                    materia = "Bases de Datos",
                    fecha = "Mañana · 8:00 AM"
                )
            }

            // BOTÓN AGREGAR
            item {

                Button(
                    onClick = irRegistrarTarea,

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
                        text = "Agregar tarea",
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


@Composable
fun TareaCard(
    titulo: String,
    materia: String,
    fecha: String
) {

    Card(
        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(16.dp),

        colors = CardDefaults.cardColors(
            containerColor = androidx.compose.ui.graphics.Color.White
        )
    ) {

        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = null,
                tint = Morado
            )

            Spacer(
                modifier = Modifier.width(14.dp)
            )

            Column {

                Text(
                    text = titulo,
                    color = TextoOscuro,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = materia,
                    color = Gris,
                    fontSize = 14.sp
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = fecha,
                    color = Morado,
                    fontSize = 13.sp
                )
            }
        }
    }
}