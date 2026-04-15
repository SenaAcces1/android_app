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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.adso.senaaccess.AuthTabBar
import com.adso.senaaccess.LoginTab
import com.adso.senaaccess.ui.theme.AppTheme
import com.adso.senaaccess.ui.theme.DarkSurface
import com.adso.senaaccess.ui.theme.NeonGreen
import androidx.compose.ui.unit.dp



class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val pagerState = rememberPagerState(pageCount = { 2 })

                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        // CLAVE: El TabBar debe ir en este parámetro, NO en la Column
                        bottomBar = {
                            AuthTabBar(pagerState = pagerState)
                        }
                    ) { paddingValues ->
                        // El contenido (HorizontalPager) ocupará el resto de la pantalla
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
                                            modifier = Modifier.fillMaxSize().background(DarkSurface),
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