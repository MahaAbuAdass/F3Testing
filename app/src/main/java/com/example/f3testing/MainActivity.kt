package com.example.f3testing

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.f3testing.presentation.Account
import com.example.f3testing.presentation.ServiceScreen
import com.example.f3testing.presentation.theme.F3TestingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            F3TestingTheme {

                val sharedPreferences: SharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
                val navController = rememberNavController()



                NavHost(navController = navController, startDestination = Screen.Home.route ) {

                    composable(Screen.Home.route){
                        ServiceScreen(sharedPreferences = sharedPreferences , navController = navController)
                    }

                    composable(Screen.Account.route){
                        Account(navController)
                    }
                }
            }
        }
    }
}
