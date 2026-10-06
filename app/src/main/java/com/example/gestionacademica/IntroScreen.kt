package com.example.gestionacademica

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IntroScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Morado),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "ESTUDIA+",
                color = Color.White,
                fontSize = 38.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = "Organiza. Aprende. Progresa.",
                color = Color.White.copy(alpha = 0.9f),
                fontSize = 17.sp
            )

            Spacer(
                modifier = Modifier.height(35.dp)
            )

            Row {

                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(
                            Color.White,
                            CircleShape
                        )
                )

                Spacer(
                    modifier = Modifier.width(6.dp)
                )

                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(
                            Color.White.copy(alpha = 0.5f),
                            CircleShape
                        )
                )

                Spacer(
                    modifier = Modifier.width(6.dp)
                )

                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(
                            Color.White.copy(alpha = 0.5f),
                            CircleShape
                        )
                )
            }
        }
    }
}