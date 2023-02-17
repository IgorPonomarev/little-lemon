package com.example.littlelemon.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.R
import com.example.littlelemon.database.MenuItem
import com.example.littlelemon.ui.composables.CustomTopAppBar
import com.example.littlelemon.ui.composables.MenuItem
import com.example.littlelemon.ui.composables.TopBarLogo
import com.example.littlelemon.ui.navigation.Profile
import com.example.littlelemon.ui.theme.PrimaryGreen
import com.example.littlelemon.ui.theme.PrimaryYellow
import com.example.littlelemon.ui.theme.Typography

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Home(navController: NavController, menuItems: List<MenuItem>) {
    var searchText by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("", TextRange(0, 7)))
    }
    val categories: Set<String> = menuItems.map { it.category }.toSet()
    Scaffold(
        topBar = {
            CustomTopAppBar("Home") {
                navController.navigate(Profile.route)
            }
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(PrimaryGreen)
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "Little Lemon",
                        style = Typography.h1,
                        color = PrimaryYellow,
                        modifier = Modifier
                            .height(60.dp)
                    )
                    Row(verticalAlignment = Alignment.Bottom) {
                        Column() {
                            Text(
                                text = "Chicago",
                                style = Typography.h2,
                                color = Color.White
                            )
                            Text(
                                text = "We are a family-owned Mediterranean restaurant, focused on traditional recipes served with a modern twist",
                                style = Typography.body1,
                                color = Color.White,
                                modifier = Modifier
                                    .width(250.dp)
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Image(
                            painter = painterResource(id = R.drawable.hero_image),
                            contentDescription = "restaurant photo",
                            modifier = Modifier
                                .height(110.dp)
                                .width(100.dp)
                                .clip(RoundedCornerShape(12.dp)),
                            contentScale = ContentScale.FillWidth
                        )
                    }
                    TextField(
                        value = searchText,
                        singleLine = true,
                        onValueChange = { searchText = it },
                        label = { Text(text = "Search for a dish") },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(16.dp)
                ) {
                    Text(
                        text = "ORDER FOR DELIVERY!",
                        style = Typography.body1,
                        fontWeight = FontWeight.ExtraBold
                    )
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        items(categories.toList()) {
                            Chip(
                                onClick = { /*TODO*/ },
                                modifier = Modifier.padding(end = 8.dp)
                            ) {
                                Text(text = it, fontWeight = FontWeight.ExtraBold)
                            }
                        }
                    }
                }
                LazyColumn() {
                    itemsIndexed(menuItems.filter { it.title.contains(searchText.text, ignoreCase = true) }) { index, it ->
                        Divider(
                            color = Color.LightGray, thickness = 1.dp,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        MenuItem(
                            title = it.title,
                            description = it.description,
                            price = it.price,
                            image = it.image
                        )
                    }
                }
            }
        }
    )
}


@Preview
@Composable
fun Preview() {
    Home(navController = rememberNavController(), emptyList())
}
