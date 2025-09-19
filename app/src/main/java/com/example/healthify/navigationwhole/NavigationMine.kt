package com.example.healthify.navigationwhole

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.healthify.baharwala.MainScreen
import com.example.healthify.baharwala.StepCounterScreen
import com.example.healthify.bmi.UnitConverter
import com.example.healthify.chatbot.ChatPage
import com.example.healthify.chatbot.ChatViewModel
import com.example.healthify.goals.db.screen.Navigation
import com.google.ai.client.generativeai.Chat

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun kNavigation(){
    val navcontroller = rememberNavController()
    val chatViewModel: ChatViewModel = viewModel()
    NavHost(navController = navcontroller, startDestination = "mainscreen"){
        composable(gainScreen.MainScreen.route){
            MainScreen(navcontroller)
        }
        composable(gainScreen.UnitConverter.route){
            UnitConverter()
        }
        composable(gainScreen.Navigation.route){
           Navigation()
        }
        composable(gainScreen.ChatPage.route){
            ChatPage(modifier = Modifier.padding(8.dp),chatViewModel,navcontroller)
        }
        composable(gainScreen.stepcounter.route){
            StepCounterScreen()
        }

    }
}