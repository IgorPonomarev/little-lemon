package com.example.littlelemon.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.R
import com.example.littlelemon.ui.theme.PrimaryGreen
import com.example.littlelemon.ui.theme.Typography

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Onboarding() {
    var firstName by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("", TextRange(0, 7)))
    }
    var lastName by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("", TextRange(0, 7)))
    }
    var emailAddress by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("", TextRange(0, 7)))
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Little lemon logo", //stringResource(R.string.cd_little_lemon_logo)
                modifier = Modifier
                    .width(185.dp)
                    .height(40.dp)
            )
        }
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
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 40.dp).fillMaxWidth()
        )
        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text(text = stringResource(R.string.first_name)) },
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 32.dp).fillMaxWidth()
        )
        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text(text = stringResource(R.string.last_name)) },
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 24.dp).fillMaxWidth()
        )
        OutlinedTextField(
            value = emailAddress,
            onValueChange = { emailAddress = it },
            label = { Text(text = stringResource(R.string.email_address)) },
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 24.dp).fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 32.dp).fillMaxWidth()
            ) {
                Text(text = "Register", style = Typography.button, color = Color.Black)
            }
        }
    }
}
