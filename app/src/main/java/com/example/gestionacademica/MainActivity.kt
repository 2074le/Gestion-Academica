package com.example.gestionacademica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import androidx.activity.compose.BackHandler

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {

            MaterialTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Fondo
                ) {

                    App()
                }
            }
        }
    }
}


@Composable
fun App() {

    // --------------------------------
    // VARIABLES DE NAVEGACIÓN
    // --------------------------------

    var mostrarIntro by remember {
        mutableStateOf(true)
    }

    var mostrarRegistro by remember {
        mutableStateOf(false)
    }

    var mostrarInicio by remember {
        mutableStateOf(false)
    }

    var registrarTarea by remember {
        mutableStateOf(false)
    }

    var mostrarVark by remember {
        mutableStateOf(false)
    }

    BackHandler {

        if (mostrarVark) {

            mostrarVark = false

        } else if (registrarTarea) {

            registrarTarea = false

        } else if (mostrarInicio) {

            mostrarInicio = false

        } else if (mostrarRegistro) {

            mostrarRegistro = false

        }
    }

    // --------------------------------
    // INTRO
    // --------------------------------

    LaunchedEffect(Unit) {

        delay(2500)

        mostrarIntro = false
    }


    // --------------------------------
    // NAVEGACIÓN
    // --------------------------------

    if (mostrarIntro) {

        IntroScreen()

    } else if (mostrarInicio) {

        // --------------------------------
        // TEST VARK
        // --------------------------------

        if (mostrarVark) {

            VarkScreen(
                volverInicio = {

                    mostrarVark = false
                }
            )

        }

        // --------------------------------
        // REGISTRAR TAREA
        // --------------------------------

        else if (registrarTarea) {

            RegistrarTareaScreen(
                volverInicio = {

                    registrarTarea = false
                }
            )

        }

        // --------------------------------
        // INICIO
        // --------------------------------

        else {

            InicioScreen(

                irRegistrarTarea = {

                    registrarTarea = true
                },

                irVark = {

                    mostrarVark = true
                }
            )
        }

    } else {

        // --------------------------------
        // REGISTRO
        // --------------------------------

        if (mostrarRegistro) {

            RegistroScreen(

                volverLogin = {

                    mostrarRegistro = false
                }
            )

        }

        // --------------------------------
        // LOGIN
        // --------------------------------

        else {

            LoginScreen(

                irRegistro = {

                    mostrarRegistro = true
                },

                iniciarSesion = {

                    mostrarInicio = true
                }
            )
        }
    }
}