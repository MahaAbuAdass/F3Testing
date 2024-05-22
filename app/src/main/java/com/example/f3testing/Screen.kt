package com.example.f3testing

sealed class Screen(val route : String) {
    object Home : Screen("home")
    object Account : Screen ("account")

    object AcessCard : Screen("access_card")
}
