package com.example.gestionacademica

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    irRegistro: () -> Unit,
    iniciarSesion: () -> Unit
) {

    var correo by remember {
        mutableStateOf("")
    }

    var contrasena by remember {
        mutableStateOf("")
    }

    var mostrarContrasena by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Fondo)
            .padding(horizontal = 25.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(
            modifier = Modifier.height(70.dp)
        )

        Text(
            text = "ESTUDIA+",
            color = Morado,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        Text(
            text = "¡Hola de nuevo!",
            color = TextoOscuro,
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Inicia sesión para continuar",
            color = Gris,
            fontSize = 15.sp
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        OutlinedTextField(
            value = correo,

            onValueChange = {
                correo = it
            },

            modifier = Modifier.fillMaxWidth(),

            label = {
                Text("Correo electrónico")
            },

            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null
                )
            },

            singleLine = true,

            shape = RoundedCornerShape(14.dp)
        )

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        OutlinedTextField(
            value = contrasena,

            onValueChange = {
                contrasena = it
            },

            modifier = Modifier.fillMaxWidth(),

            label = {
                Text("Contraseña")
            },

            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null
                )
            },

            trailingIcon = {

                TextButton(
                    onClick = {
                        mostrarContrasena = !mostrarContrasena
                    }
                ) {

                    Text(
                        text = if (mostrarContrasena) {
                            "Ocultar"
                        } else {
                            "Ver"
                        },

                        color = Morado
                    )
                }
            },

            visualTransformation =
                if (mostrarContrasena) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },

            singleLine = true,

            shape = RoundedCornerShape(14.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {

            TextButton(
                onClick = {
                    // Lo programaremos después
                }
            ) {

                Text(
                    text = "¿Olvidaste tu contraseña?",
                    color = Morado
                )
            }
        }

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Button(
            onClick = {
                iniciarSesion()
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Morado
            ),

            shape = RoundedCornerShape(14.dp)
        ) {

            Text(
                text = "Iniciar sesión",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "¿No tienes una cuenta?",
                color = Gris
            )

            TextButton(
                onClick = {
                    irRegistro()
                }
            ) {

                Text(
                    text = "Registrarse",
                    color = Morado,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}