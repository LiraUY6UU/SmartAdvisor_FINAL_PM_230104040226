package com.example.smartadvisor.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartadvisor.data.AcademicRecordEntity
import com.example.smartadvisor.data.SmartAdvisorDao
import com.example.smartadvisor.data.UserEntity
import com.example.smartadvisor.ui.theme.BluePrimary
import com.example.smartadvisor.ui.theme.BlueSecondary
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController, dao: SmartAdvisorDao) {
    val scope = rememberCoroutineScope()
    var uid by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(BluePrimary, Color(0xFF003355))
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                Icons.Default.School,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(80.dp)
            )
            Text(
                "SmartAdvisor",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                "Digital Academic Consultation",
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(40.dp))

            Card(
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(24.dp)) {
                    OutlinedTextField(
                        value = uid,
                        onValueChange = { uid = it },
                        label = { Text("NIM / NIP") },
                        leadingIcon = { Icon(Icons.Default.Person, null) },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedTextField(
                        value = pass,
                        onValueChange = { pass = it },
                        label = { Text("Password") },
                        leadingIcon = { Icon(Icons.Default.Lock, null) },
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Button(
                        onClick = {
                            scope.launch {
                                val user = dao.login(uid, pass)
                                if (user != null) {
                                    if (user.role == "STUDENT") navController.navigate("student_dash/${user.id}")
                                    else navController.navigate("advisor_dash")
                                }
                            }
                        },
                        modifier = Modifier.fillMaxWidth().height(56.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = BluePrimary)
                    ) {
                        Text("LOGIN", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            TextButton(onClick = {
                scope.launch {
                    dao.insertUser(UserEntity("2301", "Lira Anggraini", "123", "STUDENT"))
                    dao.insertUser(UserEntity("1980", "Dr. Ahmad", "123", "ADVISOR"))
                    dao.insertRecord(AcademicRecordEntity(studentId = "2301", courseName = "Mobile Programming", grade = "A", sks = 3))
                    dao.insertRecord(AcademicRecordEntity(studentId = "2301", courseName = "Database System", grade = "A-", sks = 3))
                }
            }) {
                Text("Setup Data Beta", color = Color.White.copy(alpha = 0.8f))
            }
        }
    }
}