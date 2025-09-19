package com.example.healthify.goals.screen
import android.app.Application
class HealthifyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Database init at app start
        Graph.provide(this)
    }
}