package com.example.kmmsocial.android.common.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.kmmsocial.android.R
import com.example.kmmsocial.android.common.theming.SmallElevation
import com.example.kmmsocial.android.destinations.HomeScreenDestination
import com.example.kmmsocial.android.destinations.LoginDestination
import com.example.kmmsocial.android.destinations.SignUpDestination
import com.ramcosta.composedestinations.utils.currentDestinationAsState

@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,


    ) {

    val currentDestination = navHostController.currentDestinationAsState().value
    Surface(
        modifier = modifier, elevation = SmallElevation
    ) {
        TopAppBar(title = {
            Text(text = stringResource(id = getAppBarTitle(currentDestination?.route)))
        }, modifier = modifier, backgroundColor = MaterialTheme.colors.surface, actions = {
            AnimatedVisibility(visible = currentDestination?.route == HomeScreenDestination.route) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.person_circle_icon),
                        contentDescription = null
                    )
                }
            }
        },
            navigationIcon = if (shouldShowAppBarIcon(currentDestination?.route)) {
                {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.round_arrow_back),
                            contentDescription = null
                        )
                    }
                }
            } else {
                null
            }
        )
    }
}

private fun getAppBarTitle(currentDestination: String?): Int {
    return when (currentDestination) {
        LoginDestination.route -> R.string.login_destination_title
        SignUpDestination.route -> R.string.sign_up_destination_title
        HomeScreenDestination.route -> R.string.home_screen_destination_title
        else -> R.string.no_destination_title
    }
}

private fun shouldShowAppBarIcon(currentDestination: String?): Boolean {
    return false
}