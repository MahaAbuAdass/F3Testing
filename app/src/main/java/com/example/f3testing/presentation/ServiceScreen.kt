package com.example.f3testing.presentation

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.f3testing.R
import com.example.f3testing.domain.model.ServicesDataModel
import com.example.f3testing.presentation.servicesscreen.GetServicesViewModel


@Composable
fun ServiceScreen(
   viewModel: GetServicesViewModel = hiltViewModel()
) {
    val services = viewModel.services

    Log.v("services list" , services.toString())


    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier.padding(8.dp)

        ) {
            Image(
                painter = painterResource(id = R.drawable.menu_24),
                contentDescription = "Image",
                modifier = Modifier
                    .size(50.dp)
            )

            Text(text = "Welcome")
            Text(text = "Maha")

        }

        LazyColumn(
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(services.chunked(3)) { rowIndex, rowItems ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    rowItems.forEach { serviceItem ->
                        ServiceCard(serviceItem = serviceItem)
                    }
                }
            }
        }

    }
}
@Composable
fun ServiceCard(serviceItem: ServicesDataModel) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(8.dp))
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            .clickable { /* Handle click on card */ }
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = serviceItem.title.toString() )
           Text(text = serviceItem.id.toString())
            // Add more information from your service item as needed
        }
    }
}