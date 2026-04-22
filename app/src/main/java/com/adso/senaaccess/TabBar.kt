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
fun AuthTabBar(pagerState: PagerState, onHomeClick: () -> Unit) {
    val scope = rememberCoroutineScope()

    val tabs = listOf(
        AuthTab("Home", R.drawable.ic_home),
        AuthTab("Ingresar", R.drawable.ic_login_buttom),
        AuthTab("Registro", R.drawable.ic_register)
    )

    NavigationBar(
        containerColor = DarkBg,
        tonalElevation = 0.dp
    ) {
        tabs.forEachIndexed { index, tab ->
            // El tab 0 es Home, los tabs 1 y 2 corresponden a las páginas 0 y 1 del pager
            val isSelected = when (index) {
                0 -> false // Home nunca está "seleccionado" en este pager, nos saca de aquí
                1 -> pagerState.currentPage == 0
                2 -> pagerState.currentPage == 1
                else -> false
            }

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    when (index) {
                        0 -> onHomeClick()
                        1 -> scope.launch { pagerState.animateScrollToPage(0) }
                        2 -> scope.launch { pagerState.animateScrollToPage(1) }
                    }
                },
                label = {
                    Text(
                        text = tab.label,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
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
                    selectedIconColor = Color.Black,
                    indicatorColor = NeonGreen,
                    selectedTextColor = NeonGreen,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray
                )
            )
        }
    }
}