package com.example.healthify


import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.healthify.chatbot.ChatPage
import com.example.healthify.chatbot.ChatViewModel
import com.example.healthify.navigationwhole.kNavigation
import com.example.healthify.ui.theme.HealthifyTheme


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // isko instamce bna rha hoon mein bhai ->
        val chatViewModel = ViewModelProvider(this)[ChatViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            HealthifyTheme {
           kNavigation()
            }
        }
    }
}