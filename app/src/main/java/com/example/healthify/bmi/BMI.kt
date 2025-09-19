package com.example.healthify.bmi

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.DecimalFormat

@Composable
fun UnitConverter() {
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var bmi by remember { mutableStateOf(0.0) }
    var remark by remember { mutableStateOf("") }
    fun calculateBMI(weight: Double, height: Double): Double {
        return weight / (height * height)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .border(3.dp, Color(0xFF87CEEB), shape = RoundedCornerShape(12.dp))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "BMI Calculator",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(20.dp))

                OutlinedTextField(
                    value = height,
                    onValueChange = { height = it },
                    label = { Text("Enter Height (m)") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFFFF7043), // SkyBlue jab focus ho
                        unfocusedBorderColor = Color.Gray,      // border jab focus nahi ho
                        cursorColor = Color(0xFFFF7043),        // cursor ka color
                        focusedLabelColor = Color(0xFFFF7043),  // label jab focus ho
                        unfocusedLabelColor = Color.DarkGray
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = weight,
                    onValueChange = { weight = it },
                    label = { Text("Enter Weight (kg)") }
                )

                Spacer(modifier = Modifier.height(20.dp))

                val df = DecimalFormat("#.##")
                Text(
                    text = "Your Result is: ${df.format(bmi)}",
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                if (remark.isNotEmpty()) {
                    Text(
                        text = "Remark: $remark",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                if (height.isNotBlank() && weight.isNotBlank()) {
                    bmi = calculateBMI(weight.toDouble(), height.toDouble())
                    remark = when {
                        bmi < 18.5 -> "Underweight"
                        bmi in 18.5..24.9 -> "Normal"
                        else -> "Overweight"
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF87CEEB), // SkyBlue background
                contentColor = Color.White          // Text color
            )
        ) {
            Text("Calculate BMI ")
        }
    }
}
@Preview
@Composable
fun PreviewUnitConverter() {
    UnitConverter()
}
