package com.example.littlelemon.ui.screens

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.edit
import androidx.navigation.NavController
import com.example.littlelemon.R
import com.example.littlelemon.ui.composables.TopBarLogo
import com.example.littlelemon.ui.navigation.Profile
import com.example.littlelemon.ui.theme.PrimaryGreen
import com.example.littlelemon.ui.theme.Typography

//@Preview
@Composable
fun Home(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        TopBarLogo()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .background(PrimaryGreen),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Box(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp, end = 16.dp)
                    .size(48.dp)
                    .clickable {
                        navController.navigate(Profile.route)
                    }

            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_account_circle_24),
                    colorFilter = ColorFilter.tint(Color.LightGray),
                    modifier = Modifier
                        .padding(8.dp)
                        .size(32.dp),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = stringResource(R.string.cd_little_lemon_logo)
                )
            }
        }
//        Text(
//            text = "Personal information",
//            style = Typography.subtitle1,
//            modifier = Modifier
//                .padding(start = 16.dp, end = 16.dp, top = 40.dp)
//                .fillMaxWidth()
//        )
//        OutlinedTextField(
//            value = firstName,
//            singleLine = true,
//            onValueChange = { firstName = it },
//            label = { Text(text = stringResource(R.string.first_name)) },
//            modifier = Modifier
//                .padding(start = 16.dp, end = 16.dp, top = 32.dp)
//                .fillMaxWidth()
//        )
//        OutlinedTextField(
//            value = lastName,
//            singleLine = true,
//            onValueChange = { lastName = it },
//            label = { Text(text = stringResource(R.string.last_name)) },
//            modifier = Modifier
//                .padding(start = 16.dp, end = 16.dp, top = 24.dp)
//                .fillMaxWidth()
//        )
//        OutlinedTextField(
//            value = emailAddress,
//            singleLine = true,
//            onValueChange = { emailAddress = it },
//            label = { Text(text = stringResource(R.string.email_address)) },
//            modifier = Modifier
//                .padding(start = 16.dp, end = 16.dp, top = 24.dp)
//                .fillMaxWidth()
//        )
//        Row(
//            modifier = Modifier
//                .fillMaxWidth(),
//            horizontalArrangement = Arrangement.Center
//        ) {
//            Button(
//                onClick = logOutClickHandler,
//                modifier = Modifier
//                    .padding(start = 16.dp, end = 16.dp, top = 32.dp)
//                    .fillMaxWidth()
//            ) {
//                Text(text = "Log Out", style = Typography.button, color = Color.Black)
//            }
//        }
    }
}