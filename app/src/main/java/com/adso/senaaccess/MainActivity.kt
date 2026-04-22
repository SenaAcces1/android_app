package com.adso.senaaccess

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.adso.senaaccess.ui.theme.AppTheme
import com.adso.senaaccess.ui.theme.DarkSurface
import com.adso.senaaccess.ui.theme.NeonGreen

// Enumeración simple para saber en qué pantalla estamos
enum class AppScreen { HOME, AUTH }

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // Estados para controlar la navegación
                var currentScreen by remember { mutableStateOf(AppScreen.HOME) }
                var initialAuthPage by remember { mutableIntStateOf(0) }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Lógica de navegación principal
                    if (currentScreen == AppScreen.HOME) {
                        // Mostramos el Home que acabamos de crear
                        Home(
                            onNavigateToLogin = {
                                initialAuthPage = 0 // Va a la pestaña Iniciar Sesión
                                currentScreen = AppScreen.AUTH
                            },
                            onNavigateToRegister = {
                                initialAuthPage = 1 // Va a la pestaña Registro
                                currentScreen = AppScreen.AUTH
                            }
                        )
                    } else {

                        val pagerState = rememberPagerState(
                            initialPage = initialAuthPage,
                            pageCount = { 2 }
                        )

                        Scaffold(
                            modifier = Modifier.fillMaxSize(),
                            bottomBar = {
                                AuthTabBar(
                                    pagerState = pagerState,
                                    onHomeClick = { currentScreen = AppScreen.HOME }
                                )
                            }
                        ) { paddingValues ->
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(paddingValues)
                            ) {
                                HorizontalPager(

                                    state = pagerState,
                                    modifier = Modifier.weight(1f)
                                ) { page ->
                                    when (page) {
                                        0 -> LoginTab()
                                        1 -> {
                                            Box(
                                                modifier = Modifier
                                                    .fillMaxSize()
                                                    .background(DarkSurface),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Text(
                                                    text = "El registro está deshabilitado temporalmente.\nContacte al administrador de CCyS.",
                                                    color = NeonGreen,
                                                    textAlign = TextAlign.Center,
                                                    modifier = Modifier.padding(24.dp)
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}