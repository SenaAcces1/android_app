package com.adso.senaaccess

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.rememberScrollState

import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.SegmentedButtonDefaults.borderStroke

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter

import androidx.compose.ui.res.painterResource

// Import colores
import com.adso.senaaccess.ui.theme.*

@Composable
fun LoginTab() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBg) // Fondo oscuro base
    ) {
        // --- 1. FONDO CON PATRÓN (Opcional) ---
        // Si tienes una imagen de patrón oscura, colócala aquí.
        /*
        Image(
            painter = painterResource(id = R.drawable.bg_pattern), // Reemplaza con tu patrón
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.1f // Muy sutil
        )
        */

        // --- 2. CONTENEDOR CENTRAL (Tarjeta con borde neón sutil) ---
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState()), // Por si el teclado tapa contenido
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            // ---  LOGO SENA Y TÍTULO ---
            // Logo (Usamos ColorFilter para teñirlo de neón)
            Image(
                painter = painterResource(id = R.drawable.logo_sena), // Asegúrate de tener este drawable
                contentDescription = "SENA Logo",
                modifier = Modifier.size(90.dp),
                colorFilter = ColorFilter.tint(NeonGreen) // Efecto neón en el logo
            )

            Text(
                text = "SENA",
                color = NeonGreen,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp
            )
            Text(
                text = "Acceso CCyS",
                color = NeonGreen,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 4.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = TextGray.copy(alpha = 0.3f), thickness = 1.dp)
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Iniciar Sesión",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(32.dp))

            // ---  CAMPO CORREO
            Text(
                text = "Correo electrónico",
                color = TextGray,
                fontSize = 14.sp,
                modifier = Modifier.align(Alignment.Start)
            )
            TextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    cursorColor = NeonGreen,
                    focusedIndicatorColor = NeonGreen, // Línea neón al enfocar
                    unfocusedIndicatorColor = TextGray.copy(alpha = 0.5f), // Línea gris suave
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            // --- CAMPO CONTRASEÑA (Línea) ---
            Text(
                text = "Contraseña",
                color = TextGray,
                fontSize = 14.sp,
                modifier = Modifier.align(Alignment.Start)
            )
            TextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val iconRes = if (passwordVisible) R.drawable.ic_open_eye else R.drawable.ic_closed_eye
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = painterResource(id = iconRes),
                            contentDescription = null,
                            tint = NeonGreen // Icono de ojo en verde neón
                        )
                    }
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    cursorColor = NeonGreen,
                    focusedIndicatorColor = NeonGreen,
                    unfocusedIndicatorColor = TextGray.copy(alpha = 0.5f),
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(48.dp))

            // ---  BOTÓN INGRESAR (Verde Neón Sólido) ---
            Button(
                onClick = { /* Lógica de Login */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = NeonGreen,
                    contentColor = Color.Black // Texto negro para contraste
                )
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_login_buttom), // Icono de flecha
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "INGRESAR",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        letterSpacing = 1.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Separador con el "o" central
            Row(verticalAlignment = Alignment.CenterVertically) {
                Divider(modifier = Modifier.weight(1f), color = TextGray.copy(alpha = 0.3f))
                Text(text = "o", color = TextGray, modifier = Modifier.padding(horizontal = 16.dp))
                Divider(modifier = Modifier.weight(1f), color = TextGray.copy(alpha = 0.3f))
            }

            Spacer(modifier = Modifier.height(24.dp))

            // --- BOTÓN INVITADO (Bordeado Neón) ---
            OutlinedButton(
                onClick = { /* Lógica Invitado */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                shape = RoundedCornerShape(12.dp),
                border = borderStroke(NeonGreen, 2.dp), // Borde neón grueso
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = NeonGreen // Texto verde neón
                )
            ) {
                Text(
                    text = "INVITADO",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    letterSpacing = 2.sp
                )
            }

            Spacer(modifier = Modifier.height(40.dp))



                }
            }
        }
