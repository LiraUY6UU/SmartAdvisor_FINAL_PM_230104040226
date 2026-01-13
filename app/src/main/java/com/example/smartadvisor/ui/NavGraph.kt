package com.example.smartadvisor.ui

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object StudentDash : Screen("student_dash/{userId}")
    object AdvisorDash : Screen("advisor_dash")
    object Booking : Screen("booking/{userId}/{userName}")
}