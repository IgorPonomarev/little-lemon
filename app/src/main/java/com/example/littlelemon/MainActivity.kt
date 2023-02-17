package com.example.littlelemon

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.bumptech.glide.Glide
import com.example.littlelemon.database.MenuDatabase
import com.example.littlelemon.database.MenuItem
import com.example.littlelemon.network.MenuItemNetworkData
import com.example.littlelemon.network.MenuNetworkData
import com.example.littlelemon.ui.navigation.Navigation
import com.example.littlelemon.ui.theme.LittleLemonTheme
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {

    private val sharedPreferences by lazy { getSharedPreferences("LittleLemon", MODE_PRIVATE) }

    private val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json(contentType = ContentType("text", "plain"))
        }
    }

    private val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            MenuDatabase::class.java,
            "menu.db"
        ).build()
    }

    //private val menuItemsLiveData = MutableLiveData<List<MenuItemNetworkData>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val glide = Glide.with(this)
        val isLogged = sharedPreferences.getBoolean("isLogged", false)

        lifecycleScope.launch {
            val menuItemsNetwork = getMenu()
            withContext(Dispatchers.IO) {
                database.menuDao().deleteAllMenuItems()
                database.menuDao().saveMenuItems(menuItemsNetwork.map {
                    MenuItem(
                        it.id,
                        it.title,
                        it.description,
                        it.price.toDouble(),
                        it.image,
                        it.category
                    )
                })
            }
        }


        setContent {
            LittleLemonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val menuItems by database.menuDao().getAllMenuItems()
                        .observeAsState(emptyList())
                    Navigation(isLogged, sharedPreferences, menuItems)
                }
            }
        }
    }

    private suspend fun getMenu(): List<MenuItemNetworkData> {
        val response: MenuNetworkData = client
            .get("https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json")
            .body()
        Log.d("MainActivity", "getMenu: $response")
        return response.menu
    }
}
