package com.example.healthify.navigationwhole

sealed class gainScreen(val route :String) {
    object MainScreen :gainScreen("mainscreen")
    object UnitConverter: gainScreen("unitconverter")
    object Navigation : gainScreen("db goal")
    object ChatPage : gainScreen("chatpage")
    object chatbot : gainScreen("chatbot")
    object stepcounter : gainScreen("stepcounter")
}