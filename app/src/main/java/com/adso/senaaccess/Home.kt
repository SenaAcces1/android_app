package com.adso.senaaccess

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adso.senaaccess.ui.theme.* // Asegúrate de importar tus colores

@Composable
fun Home(
    onNavigateToLogin: () -> Unit,
    onNavigateToRegister: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBg)
            .padding(horizontal = 24.dp), // Padding igual al de tu LoginTab
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Logo SENA con efecto Neón
        Image(
            painter = painterResource(id = R.drawable.logo_sena),
            contentDescription = "SENA Logo",
            modifier = Modifier.size(120.dp),
            colorFilter = ColorFilter.tint(NeonGreen)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Textos
        Text(
            text = "Bienvenido a",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "SENA ACCESS",
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(64.dp))

        // --- 1. BOTÓN INICIAR SESIÓN (Sólido Verde, igual al de "INGRESAR") ---
        Button(
            onClick = onNavigateToLogin,
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(12.dp), // Mismo radio que en el Login
            colors = ButtonDefaults.buttonColors(
                containerColor = NeonGreen,
                contentColor = Color.Black // Texto negro para contraste
            )
        ) {
            // Sin icono, solo el texto
            Text(
                text = "INICIAR SESIÓN",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                letterSpacing = 1.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- Separador con la "o" (Igual que en la primera imagen) ---
        Row(verticalAlignment = Alignment.CenterVertically) {
            Divider(modifier = Modifier.weight(1f), color = TextGray.copy(alpha = 0.3f))
            Text(text = "o", color = TextGray, modifier = Modifier.padding(horizontal = 16.dp))
            Divider(modifier = Modifier.weight(1f), color = TextGray.copy(alpha = 0.3f))
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- 2. BOTÓN REGISTRARSE (Bordeado Neón, igual al de "INVITADO") ---
        OutlinedButton(
            onClick = onNavigateToRegister,
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(2.dp, NeonGreen), // Borde neón grueso
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = NeonGreen // Texto verde neón
            )
        ) {
            // Sin icono, solo el texto
            Text(
                text = "REGISTRARSE",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                letterSpacing = 2.sp
            )
        }
    }
}