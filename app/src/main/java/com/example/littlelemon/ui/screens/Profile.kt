package com.example.littlelemon.ui.screens

import android.content.SharedPreferences
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.content.edit
import androidx.navigation.NavController
import com.example.littlelemon.R
import com.example.littlelemon.ui.composables.TopBarLogo
import com.example.littlelemon.ui.theme.Typography

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Profile(navController: NavController, sharedPreferences: SharedPreferences) {
    val context = LocalContext.current
    var firstName = sharedPreferences.getString("firstName", "Unknown") ?: "Unknown"
    var lastName = sharedPreferences.getString("lastName", "Unknown") ?: "Unknown"
    var emailAddress = sharedPreferences.getString("emailAddress", "Unknown") ?: "Unknown"
    val logOutClickHandler: () -> Unit = {
        sharedPreferences.edit(commit = true) {
            putString("firstName", "")
            putString("lastName", "")
            putString("emailAddress", "")
            putBoolean("isLogged", false)
        }
        Toast.makeText(context, "Logged out", Toast.LENGTH_SHORT).show()
        navController.navigate(com.example.littlelemon.ui.navigation.Onboarding.route)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        TopBarLogo()
        Text(
            text = "Personal information",
            style = Typography.subtitle1,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 40.dp)
                .fillMaxWidth()
        )
        OutlinedTextField(
            value = firstName,
            singleLine = true,
            onValueChange = { firstName = it },
            label = { Text(text = stringResource(R.string.first_name)) },
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 32.dp)
                .fillMaxWidth()
        )
        OutlinedTextField(
            value = lastName,
            singleLine = true,
            onValueChange = { lastName = it },
            label = { Text(text = stringResource(R.string.last_name)) },
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 24.dp)
                .fillMaxWidth()
        )
        OutlinedTextField(
            value = emailAddress,
            singleLine = true,
            onValueChange = { emailAddress = it },
            label = { Text(text = stringResource(R.string.email_address)) },
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 24.dp)
                .fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = logOutClickHandler,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 32.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Log Out", style = Typography.button, color = Color.Black)
            }
        }
    }
}