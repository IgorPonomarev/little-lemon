package com.example.littlelemon.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Entity
data class MenuItem(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val image: String,
    val category: String
)

@Dao
interface MenuDao {

    @Query("SELECT * FROM MenuItem")
    fun getAllMenuItems(): LiveData<List<MenuItem>>

    @Query("DELETE FROM MenuItem")
    fun deleteAllMenuItems()

    @Insert
    fun saveMenuItems(menuItemList: List<MenuItem>)

    @Insert
    fun saveMenuItem(menuItem: MenuItem)

    @Delete
    fun deleteMenuItem(menuItem: MenuItem)
}

@Database(entities = [MenuItem::class], version = 1)
abstract class MenuDatabase: RoomDatabase() {
    abstract fun menuDao(): MenuDao
}