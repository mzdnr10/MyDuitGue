package com.example.myduitgw.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

import androidx.compose.material3.Surface

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.example.myduitgw.ui.material.Theme
import com.example.myduitgw.ui.material.Grey50


@Composable
fun HomeScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Grey50)
    ) {

        // Background biru bagian atas
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
            color = Theme,
            shape = RoundedCornerShape(
                bottomStart = 28.dp,
                bottomEnd = 28.dp
            )
        ) {

        }

        // Konten Home
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column {

                    Text(
                        text = "Hi, Zidan!",
                        color = Color.White,
                        fontSize = 20.sp
                    )

                    Spacer(
                        modifier = Modifier.size(4.dp)
                    )

                    Text(
                        text = "Welcome Back Again",
                        color = Color.White.copy(alpha = 0.75f),
                        fontSize = 12.sp
                    )
                }

                Row {

                    IconButton(
                        onClick = {
                            // Nanti buat notifikasi
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Notifications,
                            contentDescription = "Notifikasi",
                            tint = Color.White
                        )
                    }

                    IconButton(
                        onClick = {
                            // Nanti buat settings
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Settings,
                            contentDescription = "Settings",
                            tint = Color.White
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                shape = RoundedCornerShape(20.dp),
                color = Color.White,
                shadowElevation = 4.dp
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(18.dp)
                ) {

                    Text(
                        text = "Total Saldo",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )

                    Spacer(
                        modifier = Modifier.height(2.dp)
                    )

                    Text(
                        text = "Rp 5.250.000",
                        color = Color.Black,
                        fontSize = 25.sp
                    )

                    Spacer(
                        modifier = Modifier.height(2.dp)
                    )

                    Text(
                        text = "+ Rp 1.250.000 bulan ini",
                        color = Color(0xFF35B779),
                        fontSize = 13.sp
                    )
                }
            }

            // Nanti Ringkasan
            // SummaryCard()

            // Nanti Quick Action
            // QuickAction()

            // Nanti transaksi terakhir
            // RecentTransactions()
        }
    }
}