package com.example.myduitgw.ui.screens.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBalanceWallet
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Payment
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.SwapHoriz
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.myduitgw.R
import com.example.myduitgw.ui.material.Grey50
import com.example.myduitgw.ui.material.Theme


@Composable
fun HomeScreen(
    onNavigate: (String) -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Grey50)
    ) {

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

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(
                            id = R.drawable.img_profile
                        ),
                        contentDescription = "Foto profil",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                    )

                    Spacer(
                        modifier = Modifier.width(10.dp)
                    )

                    Column {

                        Text(
                            text = "Hi, Zidan!",
                            color = Color.White,
                            fontSize = 17.sp
                        )

                        Spacer(
                            modifier = Modifier.height(2.dp)
                        )

                        Text(
                            text = "Welcome Back Again",
                            color = Color.White.copy(alpha = 0.75f),
                            fontSize = 11.sp
                        )
                    }
                }

                Row {

                    IconButton(
                        onClick = {
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

                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            horizontal = 16.dp,
                            vertical = 14.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = "Total Saldo",
                            color = Color.Gray,
                            fontSize = 12.sp
                        )

                        Spacer(
                            modifier = Modifier.height(3.dp)
                        )

                        Text(
                            text = "Rp 5.250.000",
                            color = Color.Black,
                            fontSize = 23.sp
                        )

                        Spacer(
                            modifier = Modifier.height(3.dp)
                        )

                        Text(
                            text = "+ 1.2% this week",
                            color = Color(0xFF35B779),
                            fontSize = 11.sp
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        QuickBalanceAction(
                            icon = Icons.Rounded.AccountBalanceWallet,
                            label = "Isi Saldo",
                            onClick = {
                            }
                        )

                        QuickBalanceAction(
                            icon = Icons.Rounded.SwapHoriz,
                            label = "Transfer",
                            onClick = {
                            }
                        )

                        QuickBalanceAction(
                            icon = Icons.Rounded.Payment,
                            label = "Bayar",
                            onClick = {
                            }
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            MonthlySummaryCard()

            Spacer(
                modifier = Modifier.height(18.dp)
            )

            RecentTransactionsSection(
                onViewAll = {
                    onNavigate("transactions")
                }
            )
        }
    }
}


@Composable
fun QuickBalanceAction(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Surface(
            modifier = Modifier.size(40.dp),
            shape = CircleShape,
            color = Grey50,
            onClick = onClick
        ) {

            Box(
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = icon,
                    contentDescription = label,
                    modifier = Modifier.size(23.dp),
                    tint = Theme
                )
            }
        }

        Spacer(
            modifier = Modifier.height(4.dp)
        )

        Text(
            text = label,
            color = Color.Gray,
            fontSize = 9.sp
        )
    }
}


@Composable
fun MonthlySummaryCard() {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        shape = RoundedCornerShape(20.dp),
        color = Color.White,
        shadowElevation = 4.dp
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 16.dp,
                    vertical = 14.dp
                )
        ) {

            Text(
                text = "Ringkasan Bulan Ini",
                color = Color.Black,
                fontSize = 13.sp
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Oktober 2025",
                    color = Color.Gray,
                    fontSize = 8.sp
                )

                Text(
                    text = "Next",
                    color = Color.LightGray,
                    fontSize = 8.sp
                )
            }

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier.width(78.dp)
                ) {

                    Text(
                        text = "Pemasukan",
                        color = Color.DarkGray,
                        fontSize = 9.sp
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "Pengeluaran",
                        color = Color.DarkGray,
                        fontSize = 9.sp
                    )
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(55.dp)
                ) {

                    Canvas(
                        modifier = Modifier.fillMaxSize()
                    ) {

                        val incomePath = Path().apply {

                            moveTo(
                                x = 0f,
                                y = size.height * 0.55f
                            )

                            lineTo(
                                x = size.width * 0.25f,
                                y = size.height * 0.55f
                            )

                            lineTo(
                                x = size.width * 0.45f,
                                y = size.height * 0.35f
                            )

                            lineTo(
                                x = size.width * 0.65f,
                                y = size.height * 0.40f
                            )

                            lineTo(
                                x = size.width * 0.82f,
                                y = size.height * 0.18f
                            )

                            lineTo(
                                x = size.width,
                                y = size.height * 0.22f
                            )
                        }

                        drawPath(
                            path = incomePath,
                            color = Color(0xFF35B779),
                            style = androidx.compose.ui.graphics.drawscope.Stroke(
                                width = 5f
                            )
                        )

                        val expensePath = Path().apply {

                            moveTo(
                                x = 0f,
                                y = size.height * 0.78f
                            )

                            lineTo(
                                x = size.width * 0.20f,
                                y = size.height * 0.72f
                            )

                            lineTo(
                                x = size.width * 0.40f,
                                y = size.height * 0.75f
                            )

                            lineTo(
                                x = size.width * 0.60f,
                                y = size.height * 0.68f
                            )

                            lineTo(
                                x = size.width * 0.78f,
                                y = size.height * 0.72f
                            )

                            lineTo(
                                x = size.width,
                                y = size.height * 0.60f
                            )
                        }

                        drawPath(
                            path = expensePath,
                            color = Color(0xFF4A90E2),
                            style = androidx.compose.ui.graphics.drawscope.Stroke(
                                width = 5f
                            )
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.width(8.dp)
                )

                Column(
                    horizontalAlignment = Alignment.End
                ) {

                    Text(
                        text = "Rp 12M",
                        color = Color.DarkGray,
                        fontSize = 9.sp
                    )

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    Text(
                        text = "Rp 7.5M",
                        color = Color.DarkGray,
                        fontSize = 9.sp
                    )
                }
            }
        }
    }
}


@Composable
fun RecentTransactionsSection(
    onViewAll: () -> Unit
) {

    Column {

        Text(
            text = "Transaksi Terakhir",
            color = Color.Black,
            fontSize = 13.sp
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        RecentTransactionItem(
            number = "1.",
            icon = Icons.Rounded.ShoppingCart,
            title = "GoFood - Bakso",
            date = "Oct 27, 2025 - 09:00 PM",
            amount = "- Rp 55,000",
            isIncome = false
        )

        RecentTransactionItem(
            number = "2.",
            icon = Icons.Rounded.SwapHoriz,
            title = "Transfer ke BNI - Budi",
            date = "Oct 26, 2025 - 08:30 PM",
            amount = "- Rp 250,000",
            isIncome = false
        )

        RecentTransactionItem(
            number = "3.",
            icon = Icons.Rounded.AccountBalanceWallet,
            title = "Isi Saldo (QRIS)",
            date = "Oct 25, 2025 - 08:00 PM",
            amount = "+ Rp 100,000",
            isIncome = true
        )

        Spacer(
            modifier = Modifier.height(6.dp)
        )

        Text(
            text = "Lihat Selengkapnya",
            color = Theme,
            fontSize = 10.sp,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    onClick = onViewAll
                )
                .padding(vertical = 8.dp)
        )
    }
}


@Composable
fun RecentTransactionItem(
    number: String,
    icon: ImageVector,
    title: String,
    date: String,
    amount: String,
    isIncome: Boolean
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = number,
            color = Color.DarkGray,
            fontSize = 10.sp,
            modifier = Modifier.width(18.dp)
        )

        Surface(
            modifier = Modifier.size(34.dp),
            shape = CircleShape,
            color = Grey50
        ) {

            Box(
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    modifier = Modifier.size(17.dp),
                    tint = Theme
                )
            }
        }

        Spacer(
            modifier = Modifier.width(10.dp)
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = title,
                color = Color.DarkGray,
                fontSize = 10.sp,
                maxLines = 1
            )

            Spacer(
                modifier = Modifier.height(2.dp)
            )

            Text(
                text = date,
                color = Color.Gray,
                fontSize = 7.sp
            )
        }

        Text(
            text = amount,
            color = if (isIncome) {
                Color(0xFF35B779)
            } else {
                Color(0xFFD9534F)
            },
            fontSize = 9.sp
        )
    }
}