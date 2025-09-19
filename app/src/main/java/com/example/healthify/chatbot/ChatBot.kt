package com.example.healthify.chatbot

import android.R.attr.text
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.ColorModel
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.healthify.R
import com.example.healthify.ui.theme.colorBot
import com.example.healthify.ui.theme.colorUser

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@Composable
fun ChatPage(modifier: Modifier = Modifier, viewModel: ChatViewModel,navController: NavController) {
   val navController = rememberNavController()
    Column(modifier = Modifier) {
        AppHeader(navController = navController)
        Messsagelist(modifier = Modifier.weight(1f), messageList = viewModel.messageList)
        chatmesaage(
            onMessageSend = {
                viewModel.sendMessage(it)
            }
        )
    }
}

@Composable
fun AppHeader(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Row( horizontalArrangement = Arrangement.Center){
            IconButton(onClick = {
                navController.navigate("mainscreen")
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                    contentDescription = "back",
                    tint = Color.White
                )
            }
            Text(
                modifier = Modifier.padding(16.dp),
                text = " Ask Health",
                color = Color.White,
                fontSize = 22.sp
            )
        }

    }
}

@Composable
fun MessageRow(messageModel: MessageModel) {
    val isModel = messageModel.role == "model"

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = if (isModel) Arrangement.Start else Arrangement.End
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(if (isModel) colorBot else colorUser)
                .padding(12.dp)
        ) {
            // to enable copying this ->
            SelectionContainer{
            Text(
                text = messageModel.message,
                fontWeight = FontWeight.W500,
                color = if (isModel) Color.Black else Color.White
            )
        }}
    }
}


@Composable
fun chatmesaage(onMessageSend: (String) -> Unit) {
    var message by remember { mutableStateOf("") }
    Row(
        modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            // space rkhega
            value = message,
            onValueChange = {
                message = it
            }
        )
        IconButton(onClick = {
            onMessageSend(message)
            message = ""
        }) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_send_24),
                contentDescription = "send"
            )
        }
    }
}

@Composable
fun Messsagelist(modifier: Modifier = Modifier, messageList: List<MessageModel>) {
   if(messageList.isEmpty()) {
       Column(
           modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
       )
       {
             Text(text = " Ram Ram Welcome To Chat Bot")
   }}
   else{
    LazyColumn(
        modifier = modifier,
        reverseLayout = true
    ) {
        items(messageList.reversed()) {
            MessageRow(messageModel = it)
        }
    }
}}