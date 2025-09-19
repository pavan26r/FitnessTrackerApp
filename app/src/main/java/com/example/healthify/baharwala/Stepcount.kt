package com.example.healthify.baharwala
import android.content.Context
import android.content.SharedPreferences
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import androidx.core.content.edit

class StepCountManager(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("step_prefs", Context.MODE_PRIVATE)

    fun getDailyStepCount(currentSensorValue: Float): Int {
        val lastDate = sharedPreferences.getString("last_reset_date", "")
        val currentDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())

        if (lastDate != currentDate) {
            sharedPreferences.edit {
                putString("last_reset_date", currentDate)
                    .putFloat("initial_step_count", currentSensorValue)
            }
            return 0
        } else {
            val initialCount = sharedPreferences.getFloat("initial_step_count", 0f)
            return (currentSensorValue - initialCount).toInt()
        }
    }
}