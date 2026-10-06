package com.example.gestionacademica

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class PreguntaVark(
    val pregunta: String,
    val visual: String,
    val auditivo: String,
    val lectura: String,
    val kinestesico: String
)

@Composable
fun VarkScreen(
    volverInicio: () -> Unit
) {

    val preguntas = listOf(

        PreguntaVark(
            pregunta = "Cuando quieres aprender algo nuevo, ¿qué prefieres?",
            visual = "Ver imágenes, gráficos o videos",
            auditivo = "Escuchar una explicación",
            lectura = "Leer información y tomar apuntes",
            kinestesico = "Practicar y aprender haciendo"
        ),

        PreguntaVark(
            pregunta = "Cuando estudias para un examen, ¿qué haces normalmente?",
            visual = "Utilizo mapas mentales o esquemas",
            auditivo = "Explico el tema en voz alta",
            lectura = "Leo y escribo resúmenes",
            kinestesico = "Realizo ejercicios prácticos"
        ),

        PreguntaVark(
            pregunta = "¿Cómo prefieres recibir una explicación?",
            visual = "Con imágenes o ejemplos visuales",
            auditivo = "Escuchando a otra persona",
            lectura = "Mediante un texto detallado",
            kinestesico = "Realizando una actividad"
        ),

        PreguntaVark(
            pregunta = "Cuando tienes que recordar algo, ¿qué te ayuda más?",
            visual = "Recordar una imagen",
            auditivo = "Recordar lo que escuché",
            lectura = "Leer nuevamente la información",
            kinestesico = "Recordar lo que hice"
        ),

        PreguntaVark(
            pregunta = "¿Qué recurso utilizarías para estudiar?",
            visual = "Una infografía o presentación",
            auditivo = "Un podcast o audio",
            lectura = "Un libro o documento",
            kinestesico = "Un ejercicio práctico"
        ),

        PreguntaVark(
            pregunta = "Si tienes que aprender un programa nuevo, ¿qué prefieres?",
            visual = "Ver un tutorial en video",
            auditivo = "Escuchar una explicación",
            lectura = "Leer un manual",
            kinestesico = "Probar el programa directamente"
        ),

        PreguntaVark(
            pregunta = "Cuando trabajas en grupo, ¿qué prefieres?",
            visual = "Utilizar diagramas o imágenes",
            auditivo = "Conversar sobre el tema",
            lectura = "Compartir documentos y notas",
            kinestesico = "Realizar una actividad juntos"
        ),

        PreguntaVark(
            pregunta = "¿Cómo prefieres organizar tus ideas?",
            visual = "Con dibujos, colores o diagramas",
            auditivo = "Explicándolas en voz alta",
            lectura = "Escribiendo listas o notas",
            kinestesico = "Realizando ejemplos"
        ),

        PreguntaVark(
            pregunta = "Cuando no entiendes un tema, ¿qué haces?",
            visual = "Busco un video o una imagen",
            auditivo = "Busco una explicación hablada",
            lectura = "Leo información adicional",
            kinestesico = "Intento practicarlo"
        ),

        PreguntaVark(
            pregunta = "¿Qué actividad te resulta más cómoda para estudiar?",
            visual = "Observar presentaciones",
            auditivo = "Escuchar clases o explicaciones",
            lectura = "Leer y escribir información",
            kinestesico = "Resolver ejercicios"
        ),

        PreguntaVark(
            pregunta = "Cuando recuerdas una clase, ¿qué recuerdas más fácilmente?",
            visual = "Las imágenes o diapositivas",
            auditivo = "Lo que explicó el profesor",
            lectura = "Lo que estaba escrito",
            kinestesico = "Las actividades realizadas"
        ),

        PreguntaVark(
            pregunta = "Si tienes que aprender algo rápidamente, ¿qué eliges?",
            visual = "Un video o una demostración visual",
            auditivo = "Una explicación de alguien",
            lectura = "Un resumen escrito",
            kinestesico = "Realizar una práctica"
        )
    )

    var preguntaActual by remember {
        mutableStateOf(0)
    }

    var respuestaSeleccionada by remember {
        mutableStateOf("")
    }

    var visual by remember {
        mutableStateOf(0)
    }

    var auditivo by remember {
        mutableStateOf(0)
    }

    var lectura by remember {
        mutableStateOf(0)
    }

    var kinestesico by remember {
        mutableStateOf(0)
    }

    var mostrarResultado by remember {
        mutableStateOf(false)
    }

    if (mostrarResultado) {

        ResultadoVark(
            visual = visual,
            auditivo = auditivo,
            lectura = lectura,
            kinestesico = kinestesico,
            volverInicio = volverInicio
        )

    } else {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Fondo)
                .padding(24.dp)
        ) {

            // TÍTULO

            Text(
                text = "Test VARK 🧠",
                color = Morado,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "Descubre cómo prefieres aprender",
                color = Gris,
                fontSize = 15.sp
            )

            Spacer(
                modifier = Modifier.height(25.dp)
            )

            // NÚMERO DE PREGUNTA

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Pregunta ${preguntaActual + 1} de ${preguntas.size}",
                    color = TextoOscuro,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "${(((preguntaActual + 1).toFloat() / preguntas.size) * 100).toInt()}%",
                    color = Morado,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            // BARRA DE PROGRESO

            LinearProgressIndicator(
                progress = {
                    (preguntaActual + 1).toFloat() / preguntas.size
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp),
                color = Morado,
                trackColor = MoradoClaro
            )

            Spacer(
                modifier = Modifier.height(30.dp)
            )

            // PREGUNTA

            Text(
                text = preguntas[preguntaActual].pregunta,
                color = TextoOscuro,
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(22.dp)
            )

            // OPCIÓN VISUAL

            OpcionVark(
                emoji = "👁️",
                titulo = "Visual",
                descripcion = preguntas[preguntaActual].visual,
                seleccionada = respuestaSeleccionada == "visual",
                onClick = {
                    respuestaSeleccionada = "visual"
                }
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            // OPCIÓN AUDITIVA

            OpcionVark(
                emoji = "👂",
                titulo = "Auditivo",
                descripcion = preguntas[preguntaActual].auditivo,
                seleccionada = respuestaSeleccionada == "auditivo",
                onClick = {
                    respuestaSeleccionada = "auditivo"
                }
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            // OPCIÓN LECTURA

            OpcionVark(
                emoji = "📖",
                titulo = "Lectura / Escritura",
                descripcion = preguntas[preguntaActual].lectura,
                seleccionada = respuestaSeleccionada == "lectura",
                onClick = {
                    respuestaSeleccionada = "lectura"
                }
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            // OPCIÓN KINESTÉSICA

            OpcionVark(
                emoji = "🤲",
                titulo = "Kinestésico",
                descripcion = preguntas[preguntaActual].kinestesico,
                seleccionada = respuestaSeleccionada == "kinestesico",
                onClick = {
                    respuestaSeleccionada = "kinestesico"
                }
            )

            Spacer(
                modifier = Modifier.weight(1f)
            )

            // BOTÓN CONTINUAR

            Button(
                onClick = {

                    when (respuestaSeleccionada) {

                        "visual" -> visual++

                        "auditivo" -> auditivo++

                        "lectura" -> lectura++

                        "kinestesico" -> kinestesico++
                    }

                    if (preguntaActual < preguntas.size - 1) {

                        preguntaActual++

                        respuestaSeleccionada = ""

                    } else {

                        mostrarResultado = true
                    }
                },
                enabled = respuestaSeleccionada.isNotEmpty(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Morado,
                    disabledContainerColor = MoradoClaro
                ),
                shape = RoundedCornerShape(16.dp)
            ) {

                Text(
                    text = if (preguntaActual < preguntas.size - 1)
                        "Continuar"
                    else
                        "Ver resultado",

                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


// ------------------------------------------------
// OPCIÓN DEL TEST
// ------------------------------------------------

@Composable
fun OpcionVark(
    emoji: String,
    titulo: String,
    descripcion: String,
    seleccionada: Boolean,
    onClick: () -> Unit
) {

    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (seleccionada)
                MoradoClaro
            else
                Color.White
        ),
        border = if (seleccionada)
            BorderStroke(
                2.dp,
                Morado
            )
        else
            null
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = emoji,
                fontSize = 28.sp
            )

            Spacer(
                modifier = Modifier.width(15.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = titulo,
                    color = if (seleccionada)
                        Morado
                    else
                        TextoOscuro,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
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


// ------------------------------------------------
// RESULTADO VARK
// ------------------------------------------------

@Composable
fun ResultadoVark(
    visual: Int,
    auditivo: Int,
    lectura: Int,
    kinestesico: Int,
    volverInicio: () -> Unit
) {

    val mayor = maxOf(
        visual,
        auditivo,
        lectura,
        kinestesico
    )

    val estilo = when (mayor) {

        visual -> "Visual 👁️"

        auditivo -> "Auditivo 👂"

        lectura -> "Lectura / Escritura 📖"

        else -> "Kinestésico 🤲"
    }

    val descripcion = when (estilo) {

        "Visual 👁️" ->
            "Aprendes mejor mediante imágenes, diagramas, videos y representaciones gráficas."

        "Auditivo 👂" ->
            "Aprendes mejor mediante explicaciones, conversaciones, audios y discusiones."

        "Lectura / Escritura 📖" ->
            "Aprendes mejor leyendo información, escribiendo apuntes y realizando resúmenes."

        else ->
            "Aprendes mejor mediante la práctica, los ejercicios y las experiencias."
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Fondo)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(
            modifier = Modifier.height(60.dp)
        )

        Text(
            text = "🧠",
            fontSize = 60.sp
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text = "¡Test terminado!",
            color = TextoOscuro,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Text(
            text = "Tu estilo de aprendizaje es:",
            color = Gris,
            fontSize = 16.sp
        )

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        Text(
            text = estilo,
            color = Morado,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = MoradoClaro
            )
        ) {

            Text(
                text = descripcion,
                modifier = Modifier.padding(22.dp),
                color = TextoOscuro,
                fontSize = 16.sp
            )
        }

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        // RESULTADOS

        Text(
            text = "Tus respuestas",
            color = TextoOscuro,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        Text(
            text = "👁️ Visual: $visual",
            color = TextoOscuro,
            fontSize = 15.sp
        )

        Text(
            text = "👂 Auditivo: $auditivo",
            color = TextoOscuro,
            fontSize = 15.sp
        )

        Text(
            text = "📖 Lectura / Escritura: $lectura",
            color = TextoOscuro,
            fontSize = 15.sp
        )

        Text(
            text = "🤲 Kinestésico: $kinestesico",
            color = TextoOscuro,
            fontSize = 15.sp
        )

        Spacer(
            modifier = Modifier.weight(1f)
        )

        Button(
            onClick = {
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
                text = "Volver al inicio",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}