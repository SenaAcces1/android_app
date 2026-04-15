package com.adso.senaaccess

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
// Importamos tus colores personalizados (NeonGreen, DarkBg, etc.)
import com.adso.senaaccess.ui.theme.*

data class AuthTab(val label: String, val iconRes: Int)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AuthTabBar(pagerState: PagerState) {
    val scope = rememberCoroutineScope()

    val tabs = listOf(
        AuthTab("Ingresar", R.drawable.ic_login_buttom),
        AuthTab("Registro", R.drawable.ic_register)
    )

    NavigationBar(
        // Aplicamos DarkBg para que se funda con el fondo del Login
        containerColor = DarkBg,
        tonalElevation = 0.dp // Quitamos la elevación para un look más moderno y plano
    ) {
        tabs.forEachIndexed { index, tab ->
            val isSelected = pagerState.currentPage == index

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                label = {
                    Text(
                        text = tab.label,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        // El texto de la etiqueta también cambia a neón si está seleccionado
                        color = if (isSelected) NeonGreen else Color.Gray
                    )
                },
                icon = {
                    Icon(
                        painter = painterResource(id = tab.iconRes),
                        contentDescription = tab.label,
                        modifier = Modifier.size(24.dp)
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    // Icono seleccionado en negro para que resalte sobre la "píldora" verde
                    selectedIconColor = Color.Black,
                    // La "píldora" de selección será tu verde neón
                    indicatorColor = NeonGreen,
                    // El texto seleccionado
                    selectedTextColor = NeonGreen,
                    // Colores cuando no está seleccionado
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray
                )
            )
        }
    }
}