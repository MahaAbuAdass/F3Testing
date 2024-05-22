package com.example.f3testing.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.f3testing.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccessCard(){


    Surface (modifier = Modifier.fillMaxSize()) {
        
        TopAppBar(title = {
            Row {
                Image(painter = painterResource(id = R.drawable.back), contentDescription = "" , modifier = Modifier.text)
            }
        })
        
    }

}