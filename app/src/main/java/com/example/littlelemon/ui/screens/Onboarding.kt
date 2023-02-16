package com.example.littlelemon.ui.screens

import android.content.SharedPreferences
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.edit
import androidx.navigation.NavController
import com.example.littlelemon.R
import com.example.littlelemon.ui.composables.TopBarLogo
import com.example.littlelemon.ui.navigation.Home
import com.example.littlelemon.ui.theme.PrimaryGreen
import com.example.littlelemon.ui.theme.Typography

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Onboarding(navController: NavController, sharedPreferences: SharedPreferences) {
    val context = LocalContext.current
    var firstName by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("", TextRange(0, 7)))
    }
    var lastName by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("", TextRange(0, 7)))
    }
    var emailAddress by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("", TextRange(0, 7)))
    }
    val registerClick: () -> Unit = {
        if (firstName.text == "" || lastName.text == "" || emailAddress.text == "") {
            Toast.makeText(context, "Please, populate all text fields", Toast.LENGTH_SHORT).show()
        } else {
            sharedPreferences.edit(commit = true) {
                putString("firstName", firstName.text)
                putString("lastName", lastName.text)
                putString("emailAddress", emailAddress.text)
                putBoolean("isLogged", true)
            }
            Toast.makeText(context, "Registration successful", Toast.LENGTH_SHORT).show()
            navController.navigate(Home.route)
        }
    }
    Column(modifier = Modifier.fillMaxSize()) {
        TopBarLogo()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(104.dp)
                .background(PrimaryGreen),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Let's get to know you",
                color = Color.White,
                style = Typography.body1,
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal
            )
        }
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
                onClick = registerClick,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 32.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Register", style = Typography.button, color = Color.Black)
            }
        }
    }
}
