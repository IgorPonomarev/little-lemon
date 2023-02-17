package com.example.littlelemon.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenuNetworkData(
    @SerialName("menu")
    val menu: List<MenuItemNetworkData>
)

@Serializable
data class MenuItemNetworkData(
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val image: String,
    val category: String
)