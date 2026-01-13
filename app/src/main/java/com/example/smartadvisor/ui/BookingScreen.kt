package com.example.smartadvisor.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Description
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartadvisor.data.ConsultationEntity
import com.example.smartadvisor.data.SmartAdvisorDao
import com.example.smartadvisor.ui.theme.BackgroundGray
import com.example.smartadvisor.ui.theme.BluePrimary
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingScreen(navController: NavController, dao: SmartAdvisorDao, userId: String, userName: String) {
    var topic by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("15 Januari 2026") } // Default simulasi tanggal
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Scaffold(
        containerColor = BackgroundGray,
        topBar = {
            TopAppBar(
                title = { Text("Buat Janji Konsultasi", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Kembali")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(20.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "Informasi Konsultasi",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = BluePrimary
            )
            Spacer(Modifier.height(16.dp))

            // Kartu Input
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(2.dp)
            ) {
                Column(Modifier.padding(20.dp)) {
                    // Input Tanggal (Simulasi)
                    Text("Pilih Tanggal", fontWeight = FontWeight.Medium, fontSize = 14.sp)
                    Spacer(Modifier.height(8.dp))
                    OutlinedButton(
                        onClick = { /* Dalam versi asli ini memunculkan DatePicker */ },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(Icons.Default.CalendarMonth, null, modifier = Modifier.size(18.dp))
                        Spacer(Modifier.width(8.dp))
                        Text(date)
                    }

                    Spacer(Modifier.height(20.dp))

                    // Input Topik
                    Text("Topik / Permasalahan", fontWeight = FontWeight.Medium, fontSize = 14.sp)
                    Spacer(Modifier.height(8.dp))
                    OutlinedTextField(
                        value = topic,
                        onValueChange = { topic = it },
                        placeholder = { Text("Contoh: Konsultasi judul skripsi atau KRS") },
                        modifier = Modifier.fillMaxWidth(),
                        minLines = 4,
                        shape = RoundedCornerShape(12.dp),
                        leadingIcon = { Icon(Icons.Default.Description, null) }
                    )
                }
            }

            Spacer(Modifier.weight(1f))

            // Tombol Kirim
            Button(
                onClick = {
                    if (topic.isNotEmpty()) {
                        scope.launch {
                            dao.insertConsultation(
                                ConsultationEntity(
                                    studentId = userId,
                                    studentName = userName,
                                    date = date,
                                    topic = topic,
                                    status = "PENDING"
                                )
                            )
                            Toast.makeText(context, "Berhasil mengirim pengajuan!", Toast.LENGTH_SHORT).show()
                            navController.popBackStack() // Kembali ke dashboard
                        }
                    } else {
                        Toast.makeText(context, "Harap isi topik konsultasi", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BluePrimary)
            ) {
                Text("KIRIM PENGAJUAN", fontWeight = FontWeight.ExtraBold, fontSize = 16.sp)
            }
        }
    }
}