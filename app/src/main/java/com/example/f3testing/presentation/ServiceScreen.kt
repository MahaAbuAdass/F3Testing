package com.example.f3testing.presentation

import android.content.SharedPreferences
import android.util.Log
import android.view.MenuItem
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.f3testing.R
import com.example.f3testing.domain.model.BannerDateModel
import com.example.f3testing.domain.model.ServicesDataModel
import com.example.f3testing.domain.model.VillaDetails
import com.example.f3testing.presentation.servicesscreen.GetBannerViewModel
import com.example.f3testing.presentation.servicesscreen.GetServicesViewModel
import com.example.f3testing.presentation.servicesscreen.GetVillaListViewModel
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.imageResource
import androidx.navigation.NavHostController
import com.example.f3testing.Screen
import com.example.f3testing.enums.ServiceEnum

val SELECTED_VILLA_KEY = "selected_villa"


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServiceScreen(
    viewModel: GetServicesViewModel = hiltViewModel(),
    bannerViewModel: GetBannerViewModel = hiltViewModel(),
    villaListViewModel: GetVillaListViewModel = hiltViewModel(),
    sharedPreferences: SharedPreferences , // Inject SharedPreferences,
    navController: NavHostController


) {

    var menuExpanded by remember { mutableStateOf(false) }



    val menuItems = listOf(
        NavigationItem(
            title = "Account",
            selectedIcon = Icons.Filled.Favorite,
            action = { navController.navigate(Screen.Account.route) }
        ),
        NavigationItem(
            title = "Notification",
            selectedIcon = Icons.Filled.Favorite,
            action = { /* Action for Account */ }
        ),
        NavigationItem(
            title = "Customer Support",
            selectedIcon = Icons.Filled.Favorite,
            action = { /* Action for Account */ }
        ),
        NavigationItem(
            title = "Privacy Policy",
            selectedIcon = Icons.Filled.Favorite,
            action = { /* Action for Account */ }
        ),
        NavigationItem(
            title = "About",
            selectedIcon = Icons.Filled.Favorite,
            action = { /* Action for Account */ }
        ),
        NavigationItem(
            title = "Change Language",
            selectedIcon = Icons.Filled.Favorite,
            action = { /* Action for Account */ }
        ),
        NavigationItem(
            title = "Logout",
            selectedIcon = Icons.Default.KeyboardArrowLeft,
            action = { /* Action for Account */ }
        )


    )
    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }


    // VillaDetails(villaId=8, villaNumber=5)


    var selectedVillaId by remember {
        mutableStateOf(
            sharedPreferences.getString(SELECTED_VILLA_KEY, null)
        )
    }

    val expanded = remember { mutableStateOf(false) }
    val currentValue = remember {
        mutableStateOf(selectedVillaId ?: "")
    }




    val services = viewModel.services
    val banners = bannerViewModel.banners
    val villaList = villaListViewModel.villaListData




    // Set the default value for currentValue if villaList is not empty
    villaList?.firstOrNull()?.let { firstVilla ->
        currentValue.value = firstVilla.villaId.toString()
    }


        Log.v("services list", villaList.toString())


    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier.padding(8.dp)

        ) {

            val menuTitle = if (menuExpanded) "Menu" else "" // Title for the top bar

            TopAppBar(
                title = {
                    Text(
                        text = menuTitle,
                        color = colorResource(id = R.color.yellow_new),
                        modifier = Modifier.padding(start = 120.dp)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { menuExpanded = !menuExpanded }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu" , modifier = Modifier.size(50.dp) , colorResource(
                            id = R.color.yellow_new
                        ))
                    }
                }
            )
            // Menu
            if (menuExpanded) {
                ModalDrawerSheet {

                    Spacer(modifier = Modifier.height(10.dp))
                    menuItems.forEachIndexed { index, item ->
                        NavigationDrawerItem(
                            label = { Text(text = item.title) },
                            selected = false, // Always return false for selection
                            onClick = {
                                selectedItemIndex = index
                                item.action()
                                // Handle navigation or other actions based on selected menu item
                                menuExpanded = false
                            },
                            icon = {
                                Icon(
                                    imageVector = item.selectedIcon ,
                                    contentDescription = item.title
                                )
                            },
                            badge = { item.badgeCount?.let { Text(text = it.toString()) } },
                            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                        )
                    }
                }
            }

            Text(text = "Welcome")
            Text(text = "Maha", modifier = Modifier.padding(bottom = 30.dp))




            Row(modifier = Modifier.clickable {
                expanded.value = !expanded.value
            }) {
                Row {
                    Text(text = "Villa Number ") // Provide the 'text' parameter here

                  //  Text(text = currentValue.value)
                    Text(text = selectedVillaId.toString())
                    Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = null)
                }


                DropdownMenu(
                    expanded = expanded.value,
                    onDismissRequest = {
                        expanded.value = false
                    }, modifier = Modifier.background(Color.White)
                 )
                {
                    villaList?.forEach { villa ->
                        DropdownMenuItem(onClick = {
                            currentValue.value = villa.villaId.toString()
                            selectedVillaId = villa.villaId.toString()
                            expanded.value = false
                            sharedPreferences.edit().putString(SELECTED_VILLA_KEY, selectedVillaId).apply()


                        }, text = {
                            Text("Villa Number: ${villa.villaId.toString()}" )
                        } ,
                            modifier = Modifier.background(Color.White))
                    }
                }
            }


            LazyColumn(
                modifier = Modifier.padding(top = 10.dp),
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
                                ServiceCard(serviceItem = serviceItem , onItemClick = {} , navController)



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
            ),
        contentColor = Color.Black
    ) {

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
fun ServiceCard(serviceItem: ServicesDataModel , onItemClick: (ServicesDataModel) -> Unit ,navController: NavHostController
) {

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
            .clickable {
                       when(serviceItem.enumId){
                           ServiceEnum.REQUEST_ACCESS_CARD.type -> { navController.navigate(Screen.AcessCard.route)}

                           ServiceEnum.HOUSE_KEEPING.type -> { }
                           ServiceEnum.INVITE_GUEST.type -> { }
                           ServiceEnum.MAINTENANCE.type -> { }
                           ServiceEnum.NOC.type -> { }
                           ServiceEnum.PAYMENT.type -> { }
                       }
            },
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
                style = TextStyle(fontSize = 13.sp, color = Color(R.color.yellow_new))
            )


        }
    }
}


data class NavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val badgeCount: Int? = null,
    val action: () -> Unit // Action associated with the item
)



