package com.example.kmmsocial.android

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.kmmsocial.android.auth.signup.NavGraphs
import com.ramcosta.composedestinations.DestinationsNavHost

@Composable
fun SocialApp() {
    val navHostController = rememberNavController()
    
    DestinationsNavHost(navGraph = NavGraphs.root, navController = navHostController)
}