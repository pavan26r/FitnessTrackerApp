package com.example.healthify.chatbot

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.Content
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch
import kotlin.getValue

class ChatViewModel : ViewModel() {

   val messageList by lazy { mutableStateListOf<MessageModel>() }

     val generativeModel = GenerativeModel(
        modelName = "gemini-1.5-flash",
        apiKey = Constants.api
    )

    // ek hi baar chat instance banake reuse karenge
    private val chat = generativeModel.startChat()

    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    @SuppressLint("SuspiciousIndentation")
    fun sendMessage(question: String) {
        viewModelScope.launch {
      // for error handling use try catch herer ->
          val chat = generativeModel.startChat(
              // sending history to the user ->
              history = messageList.map {
                  content(it.role){
                      text(it.message)}}
                  .toList()

          )
            messageList.add(MessageModel(question, "user"))
            messageList.add(MessageModel("Thinking...","model"))

            val response = chat.sendMessage(question)
            messageList.removeLast()
           messageList.add(MessageModel(response.text.toString(),"model"))
        }
    }
}
