package com.example.smartadvisor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smartadvisor.data.AppDatabase
import com.example.smartadvisor.ui.AdvisorDashboard
import com.example.smartadvisor.ui.BookingScreen
import com.example.smartadvisor.ui.LoginScreen
import com.example.smartadvisor.ui.Screen
import com.example.smartadvisor.ui.StudentDashboard
import com.example.smartadvisor.ui.theme.SmartAdvisorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = AppDatabase.getInstance(this)
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = Screen.Login.route) {
                composable(Screen.Login.route) { LoginScreen(navController, db.dao()) }
                composable(Screen.StudentDash.route) { backStack ->
                    StudentDashboard(navController, db.dao(), backStack.arguments?.getString("userId") ?: "")
                }
                composable(Screen.AdvisorDash.route) { AdvisorDashboard(db.dao()) }
                composable(Screen.Booking.route) { backStack ->
                    BookingScreen(
                        navController, db.dao(),
                        backStack.arguments?.getString("userId") ?: "",
                        backStack.arguments?.getString("userName") ?: ""
                    )
                }
            }
        }
    }
}