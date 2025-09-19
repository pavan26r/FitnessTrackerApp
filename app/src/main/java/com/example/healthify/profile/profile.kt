package com.example.healthify.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FoodTrackCard(){
    Card(
        colors = CardDefaults.cardColors(containerColor = CardColor),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ){
Column(modifier = Modifier.padding(10.dp)){
    TopSection()
    Spacer(Modifier.height(6.dp))
    FastingBanner()
    Spacer(Modifier.height(6.dp))
    PremiumSection()
    Spacer(Modifier.height(6.dp))
    MacroSection()
}    }
}
@Composable
fun TopSection() {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text("Track Food", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text("Eat 2,350 cal", color = SecondaryText, fontSize = 14.sp)
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Face, contentDescription = null, tint = Color.Black, modifier = Modifier.size(22.dp))
            Spacer(Modifier.width(12.dp))
            Icon(
                Icons.Default.Add,
                contentDescription = null,
                tint = AccentOrange,
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape)
                    .background(Color(0x1AFF7B1C)) // light bg
                    .padding(4.dp)
            )
        }
    }
}
@Composable
fun FastingBanner() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFF1F5F3))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icons.Default.ThumbUp, contentDescription = null, tint = PrimaryText, modifier = Modifier.size(28.dp))
        Spacer(Modifier.width(12.dp))
        Text("Want to start\nIntermittent Fasting?", color = PrimaryText, fontSize = 15.sp, fontWeight = FontWeight.Medium)
        Spacer(Modifier.weight(1f))
        Icon(Icons.Default.ArrowForward, contentDescription = null, tint = PrimaryText)
    }
}


@Composable
fun PremiumSection() {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(Modifier.weight(1f), color = DividerColor, thickness = 1.dp)
        Spacer(Modifier.width(8.dp))
        Icon(Icons.Default.Star, contentDescription = null, tint = PrimaryText)
        Text(" Premium", color = PrimaryText, fontWeight = FontWeight.Bold)
        Spacer(Modifier.width(8.dp))
        Divider(Modifier.weight(1f), color = DividerColor, thickness = 1.dp)
    }
}

@Composable
fun MacroSection() {
    Column {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Protein: 0%", color = SecondaryText, fontWeight = FontWeight.Medium)
            Text("Carb: 0%", color = SecondaryText, fontWeight = FontWeight.Medium)
        }
        Spacer(Modifier.height(8.dp))
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Fat: 0%", color = SecondaryText, fontWeight = FontWeight.Medium)
            Text("Fibre: 0%", color = SecondaryText, fontWeight = FontWeight.Medium)
        }
    }
}

