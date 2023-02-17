package com.example.littlelemon.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.R
import com.example.littlelemon.ui.composables.CustomTopAppBar
import com.example.littlelemon.ui.composables.TopBarLogo
import com.example.littlelemon.ui.navigation.Profile
import com.example.littlelemon.ui.theme.PrimaryGreen

@Composable
fun Home(navController: NavController) {
    Scaffold(
        topBar = {CustomTopAppBar() {
            navController.navigate(Profile.route)
        } },
        content = {padding ->
        Column(modifier = Modifier
            .padding(padding)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())) {
            TopBarLogo()
        }
    })

}


@Preview
@Composable
fun Preview() {
    Home(navController = rememberNavController())
}
