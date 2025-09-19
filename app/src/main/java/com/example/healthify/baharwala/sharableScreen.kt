package com.example.healthify.baharwala

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import com.example.healthify.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddTask
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.DirectionsWalk
import androidx.compose.material.icons.filled.LocalDrink
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextPainter.paint
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.healthify.navigationwhole.gainScreen
import java.util.jar.Manifest

@Composable
fun ss(navController: NavController) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(0.5f)
            .clickable {
                navController.navigate("unitconverter")
            }
    ) {
        Text(
            "Calculate BMI", modifier = Modifier.padding(16.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
@Composable
fun ag(navController: NavController) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .clickable {
                navController.navigate("db goal")
            }
    ) {
        Text(
            "Add Goals", modifier = Modifier.padding(16.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
@Composable
fun chatbot(navController: NavController) {
    Card(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                "Seek Guidance", modifier = Modifier.padding(16.dp),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
            IconButton(onClick = { navController.navigate(gainScreen.ChatPage.route) }) {
                Icon(
                    painter = painterResource(R.drawable.baseline_send_24),
                    contentDescription = " send"
                )
            }
        }
    }
}
@Composable
fun stepcnt(navController: NavController) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(0.5f).clickable(
                onClick = {
                    navController.navigate(gainScreen.stepcounter.route)
                }),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.DirectionsWalk, // 👣 Step Count Icon
                contentDescription = "Step Count",
                tint = Color.Blue,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text("Step Count", style = MaterialTheme.typography.titleMedium)
        }
    }
}
@Composable
fun waterintake() {
    var number by remember { mutableIntStateOf(7) }
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(0.9f),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Water ", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.width(12.dp))
            IconButton(
                onClick = { number = number - 1 },
                modifier = Modifier.size(32.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if(number>0){
                        Text(text = "$number", fontWeight = FontWeight.Bold)
                    }
                    else{
                        Icon(
                            imageVector = Icons.Filled.AddTask,
                            contentDescription = "kyun btaun",
                            modifier = Modifier.size(32.dp),
                            tint = Color.Blue
                        )
                    }
                    Icon(
                        imageVector = Icons.Filled.LocalDrink,
                        contentDescription = "kyun btaun",
                        modifier = Modifier.size(32.dp),
                        tint = Color.Blue
                    )
                }
            }
        }
        Spacer(modifier = Modifier.width(12.dp))
    }
}
@Composable()
fun Profile(){
    var name by remember{ mutableStateOf(" Pavan Kumar")}
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFF9FAF9))
        .padding(16.dp)){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(id = R.drawable.pvn), // your profile image
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )
            Row(verticalAlignment = Alignment.CenterVertically)
            {
                OutlinedButton(
                    onClick = { },
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(text = name)
                }
                Spacer(Modifier.width(8.dp))
                OutlinedButton(
                    onClick = { },
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("2 days left")
                }
                Spacer(Modifier.width(8.dp))
                IconButton(onClick = { }) {
                    Icon(Icons.Default.DateRange, contentDescription = "Calendar")
                }
            }
        }
        Spacer(Modifier.height(24.dp))
        // Title
        Text(
            text = "Your Information",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(16.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                       modifier = Modifier
                           .border(
                               width = 1.dp,
                               color = Color.LightGray,
                               shape = RoundedCornerShape(12.dp)
                           )
                           .padding(12.dp), // space inside border
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("Your Weight", fontWeight = FontWeight.Bold)
                            Text("55 kg", color = Color.Gray, fontSize = 14.sp)
                        }

                        Spacer(modifier = Modifier.width(180.dp))
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("Your height", fontWeight = FontWeight.Bold)
                            Text("1.6 mt", color = Color.Gray, fontSize = 14.sp)
                        }
                  }
                Spacer(Modifier.height(16.dp))
                Card(
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFEFF5F0)),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painter = painterResource(id = R.drawable.chamanlal),
                                contentDescription = null,
                                tint = Color(0xFF2A7B5F),
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(Modifier.width(8.dp))
                            Text("Freshup Your Mind ", color = Color(0xFF2A7B5F))
                        }
                        Icon(Icons.Default.ArrowForward, contentDescription = null)
                    }
                }
            }
        }
    }
    }

@Composable
fun StepCounterScreen() {
    val context = LocalContext.current
    val sensorManager = remember { context.getSystemService(Context.SENSOR_SERVICE) as SensorManager }
    val stepCounterSensor = remember { sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) }
    var dailystepCount by remember { mutableStateOf(0f) }
    val stepCountManager = remember{ StepCountManager(context) }
    // State to track if the permission is granted
    var hasPermission by remember { mutableStateOf(false) }
    // Launcher for requesting the ACTIVITY_RECOGNITION permission
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        hasPermission = isGranted
        if (!isGranted) {
            Toast.makeText(context,"Premission Denied",Toast.LENGTH_SHORT).show()
        }
    }

    // Request permission when the Composable is first launched
    LaunchedEffect(Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            permissionLauncher.launch(android.Manifest.permission.ACTIVITY_RECOGNITION)
        } else {
            // For older Android versions, permission is granted at install time
            hasPermission = true
        }
    }
    // Only set up the sensor listener if the permission is granted ->
    DisposableEffect(hasPermission){
        val sensorEventListener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent) {
                if (event.sensor.type == Sensor.TYPE_STEP_COUNTER) {
                    dailystepCount = event.values[0]
                }
            }
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
        }
        if (hasPermission && stepCounterSensor != null) {
            sensorManager.registerListener(
                sensorEventListener,
                stepCounterSensor,
                SensorManager.SENSOR_DELAY_UI
            )
        }
        onDispose {
            if (hasPermission && stepCounterSensor != null) {
                sensorManager.unregisterListener(sensorEventListener)
            }
        }
    }
    // UI for sensor ->
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (hasPermission) {
            // Display step count only if permission is granted
            Text(
                text = "🚶 Total Steps",
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = "${dailystepCount.toInt()}",
                style = MaterialTheme.typography.displayMedium.copy(
                    fontWeight = FontWeight.Bold
                )
            )
        } else {
            // Inform the user that permission is needed
            Text("Permission needed to track steps.")
        }
    }
}