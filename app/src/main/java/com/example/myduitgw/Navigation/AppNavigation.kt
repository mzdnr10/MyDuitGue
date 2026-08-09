package com.example.myduitgw.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.List
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import com.example.myduitgw.R

import com.example.myduitgw.ui.screens.home.HomeScreen
import com.example.myduitgw.ui.screens.settings.SettingsScreen
import com.example.myduitgw.ui.screens.tabungan.TabunganScreen
import com.example.myduitgw.ui.screens.transactions.TransactionsScreen
import com.example.myduitgw.ui.screens.upload.UploadsScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            MyBottomBar(
                currentRoute = currentRoute,
                onNavigate = { route ->
                    navController.navigate(route)
                }
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {

            composable("home") {
                HomeScreen()
            }

            composable("transactions") {
                TransactionsScreen()
            }

            composable("tabungan") {
                TabunganScreen()
            }

            composable("settings") {
                SettingsScreen()
            }

            composable("upload") {
                UploadsScreen()
            }
        }
    }
}


@Composable
fun MyBottomBar(
    currentRoute: String?,
    onNavigate: (String) -> Unit
) {

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp),
            color = Color.White,
            shadowElevation = 12.dp
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                BottomBarItem(
                    icon = Icons.Rounded.Home,
                    label = "Home",
                    selected = currentRoute == "home",
                    onClick = {
                        onNavigate("home")
                    }
                )

                BottomBarItem(
                    icon = Icons.AutoMirrored.Rounded.List,
                    label = "Transaksi",
                    selected = currentRoute == "transactions",
                    onClick = {
                        onNavigate("transactions")
                    }
                )

                // Ruang untuk tombol Scan di tengah
                Box(
                    modifier = Modifier.size(68.dp)
                )

                BottomBarItem(
                    icon = painterResource(R.drawable.ic_storage),
                    label = "Tabungan",
                    selected = currentRoute == "tabungan",
                    onClick = {
                        onNavigate("tabungan")
                    }
                )

                BottomBarItem(
                    icon = Icons.Rounded.Person,
                    label = "Akun",
                    selected = currentRoute == "settings",
                    onClick = {
                        onNavigate("settings")
                    }
                )
            }
        }

        ScanButton(
            onClick = {
                onNavigate("upload")
            }
        )
    }
}


@Composable
fun BottomBarItem(
    icon: ImageVector,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    BottomBarItemContent(
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = label,
                modifier = Modifier.size(23.dp),
                tint = if (selected) {
                    MaterialTheme.colorScheme.primary
                } else {
                    Color.Gray
                }
            )
        },
        label = label,
        selected = selected,
        onClick = onClick
    )
}


@Composable
fun BottomBarItem(
    icon: Painter,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    BottomBarItemContent(
        icon = {
            Icon(
                painter = icon,
                contentDescription = label,
                modifier = Modifier.size(23.dp),
                tint = if (selected) {
                    MaterialTheme.colorScheme.primary
                } else {
                    Color.Gray
                }
            )
        },
        label = label,
        selected = selected,
        onClick = onClick
    )
}


@Composable
private fun BottomBarItemContent(
    icon: @Composable () -> Unit,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .size(
                width = 68.dp,
                height = 64.dp
            )
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            icon()

            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                color = if (selected) {
                    MaterialTheme.colorScheme.primary
                } else {
                    Color.Gray
                },
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}


@Composable
fun ScanButton(
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .size(68.dp)
            .offset(y = (-24).dp)
            .zIndex(1f)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {

        Surface(
            modifier = Modifier
                .size(52.dp)
                .shadow(
                    elevation = 8.dp,
                    shape = CircleShape
                ),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.primary
        ) {

            Box(
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "Scan Payment",
                    modifier = Modifier.size(26.dp),
                    tint = Color.White
                )
            }
        }
    }
}