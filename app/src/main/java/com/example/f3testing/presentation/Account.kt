package com.example.f3testing.presentation

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.f3testing.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.f3testing.presentation.servicesscreen.GetUserProfileDataViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Account(
    navController: NavHostController ,
    userDataViewModel : GetUserProfileDataViewModel = hiltViewModel()
            ) {


  //  var text by remember { mutableStateOf(TextFieldValue()) }


    val userData = userDataViewModel.userData
    Log.v("user data", userData.toString())

    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()
    ) {

        Column {


            TopAppBar(
                title = {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(100.dp)
                    ) {
                        // Icon at the start
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Menu",
                            tint = colorResource(id = R.color.yellow_new),  // Adjust tint as needed
                            modifier = Modifier.padding(end = 8.dp) // Add padding between icon and title
                        )
                        // Title
                        Text(
                            text = "Account",
                            color = colorResource(id = R.color.yellow_new),
                            modifier = Modifier.padding(
                                start = 8.dp,
                                end = 8.dp
                            ) ,
                            style = TextStyle(fontWeight = FontWeight.Bold)// Add padding to the title
                        )
                        // Icon at the end
                        Text(
                            text = "Edit",
                            color = colorResource(id = R.color.yellow_new),
                            style = TextStyle(fontSize = 16.sp)
                        )
                    }
                },
            )
            Column(modifier = Modifier.padding(end = 8.dp, start = 8.dp)) {


                Text(
                    modifier = Modifier.padding(bottom = 15.dp),
                    text = "Your Name",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
                )

                Row(modifier = Modifier.padding(bottom = 5.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = "",
                    )
                    userData.name?.let { Text( modifier = Modifier.padding(start = 10.dp),text = it , style = TextStyle(color = Color.LightGray)) }
                }

                Divider(color = Color.LightGray)


                Text(
                    modifier = Modifier.padding(top = 30.dp, bottom = 15.dp),
                    text = "Phone number",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
                )
                Row() {
                    Image(
                        painter = painterResource(id = R.drawable.ic_telephone),
                        contentDescription = "",
                    )
                    Text(modifier = Modifier.padding(start = 10.dp), text = "000000000000" , style = TextStyle(color = Color.LightGray))
                }
                Divider(color = Color.LightGray)


                Text(
                    modifier = Modifier.padding(top = 30.dp, bottom = 15.dp),
                    text = "Email",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
                )

                Row(modifier = Modifier.padding(bottom = 5.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_telephone),
                        contentDescription = "",
                    )
                    userData.email?.let { Text(text = it , style = TextStyle(color = Color.LightGray)) }
                }
                Divider(color = Color.LightGray)


                Text(
                    modifier = Modifier.padding(top = 30.dp, bottom = 15.dp),
                    text = "Change Password",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
                )
                Row() {
                    Image(
                        painter = painterResource(id = R.drawable.ic_telephone),
                        contentDescription = "",
                    )
                    Text(modifier = Modifier.padding(start = 10.dp),text = "enter your current password" , style = TextStyle(color = Color.LightGray))
                }
                Divider(color = Color.LightGray)


                Text(
                    modifier = Modifier.padding(top = 30.dp, bottom = 15.dp),
                    text = "New Password",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
                )
                Row() {
                    Image(
                        painter = painterResource(id = R.drawable.ic_telephone),
                        contentDescription = "",
                    )
                    Text(modifier = Modifier.padding(start = 10.dp),
                        text = "enter your new password"
                        , style = TextStyle(color = Color.LightGray))
                }
                Divider(color = Color.LightGray)



                Text(
                    modifier = Modifier.padding(top = 30.dp, bottom = 15.dp),
                    text = "Re-enter your new password",
                    style = TextStyle(
                        fontSize = 16.sp, // Change the text size to 16sp
                        fontWeight = FontWeight.Bold
                    )
                )
                Row() {
                    Image(
                        painter = painterResource(id = R.drawable.ic_telephone),
                        contentDescription = "",
                    )

//                    TextField(value = text, onValueChange ={newValue->
//                        text = newValue
//
//                    } ,
//                        keyboardOptions = KeyboardOptions.Default.copy(
//                            imeAction = ImeAction.Done
//                        ) ,
//                        keyboardActions = KeyboardActions(onDone = null) ,
//                        label = {Text(text ="password" )} ,
//                        placeholder = { Text("re-enter your new password" , color = Color.LightGray) }
//
//                        )
                    Text(modifier = Modifier.padding(start = 10.dp),
                        text = "re-enter your new password"
                        , style = TextStyle(color = Color.LightGray))
                }
                Divider(color = Color.LightGray)


            }
        }
    }
}
