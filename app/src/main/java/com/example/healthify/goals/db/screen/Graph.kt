package com.example.healthify.goals.screen

import android.content.Context
import androidx.room.Room
import com.example.healthify.goals.dbgoal.WishDatabase
import com.example.healthify.goals.dbgoal.WishRepository

object Graph {
    lateinit var database: WishDatabase
   private set
    val wishRepository by lazy{
        WishRepository( database.wishDao())
    }

    fun provide(context: Context){
        database = Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.db").build()
    }

}