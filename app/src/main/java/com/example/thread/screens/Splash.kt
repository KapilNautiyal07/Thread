package com.example.thread.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.thread.R
import com.example.thread.navigation.Routes
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay



@Composable
fun Splash(navController: NavHostController) {


    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.threaddd), contentDescription = "logo",

            modifier =Modifier.padding(horizontal = 175.dp , vertical = 300.dp))
    }




    LaunchedEffect(true) {
        delay(3000)


        if (FirebaseAuth.getInstance().currentUser!=null)
        navController.navigate(Routes.BottomNav.routes){
            popUpTo(navController.graph.startDestinationId)
            launchSingleTop =true
        }
        else
            navController.navigate(Routes.Login.routes) {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }

    }


}