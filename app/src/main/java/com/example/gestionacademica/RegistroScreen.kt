package com.example.gestionacademica

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegistroScreen(
    volverLogin: () -> Unit
) {

    var nombre by remember {
        mutableStateOf("")
    }

    var correo by remember {
        mutableStateOf("")
    }

    var contrasena by remember {
        mutableStateOf("")
    }

    var confirmarContrasena by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Fondo)
            .padding(horizontal = 25.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(
            modifier = Modifier.height(55.dp)
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
            text = "Crear cuenta",
            color = TextoOscuro,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(7.dp)
        )

        Text(
            text = "Comienza a organizar tu estudio",
            color = Gris,
            fontSize = 15.sp
        )

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        OutlinedTextField(
            value = nombre,

            onValueChange = {
                nombre = it
            },

            modifier = Modifier.fillMaxWidth(),

            label = {
                Text("Nombre")
            },

            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
            },

            singleLine = true,

            shape = RoundedCornerShape(14.dp)
        )

        Spacer(
            modifier = Modifier.height(12.dp)
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
            modifier = Modifier.height(12.dp)
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

            visualTransformation =
                PasswordVisualTransformation(),

            singleLine = true,

            shape = RoundedCornerShape(14.dp)
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = confirmarContrasena,

            onValueChange = {
                confirmarContrasena = it
            },

            modifier = Modifier.fillMaxWidth(),

            label = {
                Text("Confirmar contraseña")
            },

            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null
                )
            },

            visualTransformation =
                PasswordVisualTransformation(),

            singleLine = true,

            shape = RoundedCornerShape(14.dp)
        )

        Spacer(
            modifier = Modifier.height(22.dp)
        )

        Button(
            onClick = {
                // Lo programaremos después
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
                text = "Crear cuenta",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "¿Ya tienes una cuenta?",
                color = Gris
            )

            TextButton(
                onClick = {
                    volverLogin()
                }
            ) {

                Text(
                    text = "Iniciar sesión",
                    color = Morado,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}