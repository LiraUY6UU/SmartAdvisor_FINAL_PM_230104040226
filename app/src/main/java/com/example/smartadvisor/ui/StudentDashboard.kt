package com.example.smartadvisor.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartadvisor.data.AcademicRecordEntity
import com.example.smartadvisor.data.SmartAdvisorDao
import com.example.smartadvisor.ui.theme.BackgroundGray
import com.example.smartadvisor.ui.theme.BluePrimary
import com.example.smartadvisor.ui.theme.BlueSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentDashboard(navController: NavController, dao: SmartAdvisorDao, userId: String) {
    // Mengambil data record dari database lokal
    var records by remember { mutableStateOf<List<AcademicRecordEntity>>(emptyList()) }
    LaunchedEffect(userId) {
        records = dao.getRecords(userId)
    }

    Scaffold(
        containerColor = BackgroundGray,
        topBar = {
            TopAppBar(
                title = { Text("Dashboard Mahasiswa", fontWeight = FontWeight.Bold) },
                actions = {
                    IconButton(onClick = {
                        // Menghapus backstack agar tidak bisa kembali ke dashboard setelah logout
                        navController.navigate("login") {
                            popUpTo("login") { inclusive = true }
                        }
                    }) {
                        Icon(Icons.Default.ExitToApp, contentDescription = "Logout")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        }
    ) { padding ->
        Column(Modifier.padding(padding).padding(20.dp)) {
            // Header Info
            Text("Selamat Datang,", color = Color.Gray)
            Text("Lira Anggraini", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)

            Spacer(Modifier.height(20.dp))

            // Kartu IPK
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = BluePrimary),
                shape = RoundedCornerShape(24.dp)
            ) {
                Row(
                    modifier = Modifier.padding(24.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text("Indeks Prestasi Kumulatif", color = Color.White.copy(alpha = 0.7f))
                        Text("3.92", style = MaterialTheme.typography.displayMedium, color = Color.White, fontWeight = FontWeight.Bold)
                    }
                    Icon(Icons.Default.TrendingUp, null, tint = Color.White, modifier = Modifier.size(50.dp))
                }
            }

            Spacer(Modifier.height(24.dp))
            Text("Layanan Akademik", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(Modifier.height(12.dp))

            // Baris Tombol Layanan
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Tombol Konsultasi yang sudah terhubung ke BookingScreen
                ServiceButton(
                    title = "Konsultasi",
                    icon = Icons.Default.Chat,
                    color = BlueSecondary,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        navController.navigate("booking/$userId/Lira Anggraini")
                    }
                )

                // Tombol Status SKS
                ServiceButton(
                    title = "Status SKS",
                    icon = Icons.Default.Info,
                    color = Color(0xFFFFE8D1),
                    modifier = Modifier.weight(1f),
                    onClick = { /* Fitur tambahan nanti */ }
                )
            }
        }
    }
}

@Composable
fun ServiceButton(
    title: String,
    icon: ImageVector,
    color: Color,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        modifier = modifier.height(120.dp),
        shape = RoundedCornerShape(20.dp),
        color = color
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(icon, null, modifier = Modifier.size(32.dp), tint = Color.DarkGray)
            Spacer(Modifier.height(8.dp))
            Text(title, fontWeight = FontWeight.Bold, color = Color.DarkGray)
        }
    }
}