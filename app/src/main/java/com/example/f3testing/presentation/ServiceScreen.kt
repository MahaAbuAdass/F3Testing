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
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.f3testing.R
import com.example.f3testing.domain.model.BannerDateModel
import com.example.f3testing.domain.model.ServicesDataModel
import com.example.f3testing.presentation.servicesscreen.GetBannerViewModel
import com.example.f3testing.presentation.servicesscreen.GetServicesViewModel
import com.example.f3testing.presentation.servicesscreen.GetVillaListViewModel


@Composable
fun ServiceScreen(
   viewModel: GetServicesViewModel = hiltViewModel() ,
   bannerViewModel: GetBannerViewModel = hiltViewModel() ,
   villaListViewModel: GetVillaListViewModel = hiltViewModel()
) {
    val services = viewModel.services
    val banners = bannerViewModel.banners

    Log.v("services list", services.toString())


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
            Text(text = "Maha" , modifier = Modifier.padding(bottom = 10.dp))



            LazyColumn(
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(services.chunked(3)) { _, rowItems ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        rowItems.forEach { serviceItem ->
                            if (serviceItem != null) {
                                ServiceCard(serviceItem = serviceItem)
                            }
                        }
                    }
                }
            }


            LazyRow(
                modifier = Modifier.padding(top = 10.dp),
            ) {

                items(banners ?: emptyList()) { bannerItem ->
                    if (bannerItem != null) {
                        BannerCard(bannerItem = bannerItem)
                    }
                }
            }

        }
    }
}


@Composable
fun BannerCard(bannerItem: BannerDateModel) {
    Surface(
        modifier = Modifier
            .width(360.dp) // Increase width of the banner
            .height(300.dp) // Increase height of the banner
            .padding(8.dp)
            .padding(top = 55.dp) // Add margin above the banner
            .clip(RoundedCornerShape(12.dp))
            .border(
                1.dp,
                colorResource(id = R.color.yellow_new),
                RoundedCornerShape(12.dp)
            )
          ,
        contentColor = Color.Black
    ){

        Image(
            painter = rememberImagePainter(
                data = bannerItem.image,
                builder = {
                    // You can apply transformations if needed
                }
            ),
            contentDescription = "Banner Image",
            modifier = Modifier
                .fillMaxSize()
                .clickable { /* Handle click action if needed */ }
        )

    }

}

@Composable
fun ServiceCard(serviceItem: ServicesDataModel) {

    Box(
        modifier = Modifier
            .width(110.dp)
            .aspectRatio(1f)
            .padding(3.dp)
            .clip(RoundedCornerShape(5.dp))
            .border(
                width = 1.dp,
                color = colorResource(id = R.color.yellow_new),
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { },
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            serviceItem.iconImg?.let { imageUrl ->
                Image(
                    painter = rememberImagePainter(
                        data = imageUrl,
                        builder = {
                            // You can apply transformations if needed
//                            placeholder(R.drawable.ic_launcher_background) // Placeholder while loading
                        }
                    ),
                    contentDescription = stringResource(id = coil.compose.base.R.string.close_drawer),
                    modifier = Modifier
                        .size(60.dp)
                        .aspectRatio(1f)
                        .padding(bottom = 7.dp)
                )
            }

            Text(
                text = serviceItem.title.toString(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 7.dp),
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 13.sp , color = Color(R.color.yellow_new))
            )


        }
    }
}




