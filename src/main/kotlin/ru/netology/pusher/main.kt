package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream
import java.sql.DriverManager.println



fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val token = "deJ9TpsXSKKp4l6PixNIxY:APA91bFwE1v4miMkAgzQRf1_MEQDZDrRSkXomjTgpABkT79eIGkSSwaLBwIOQnZiavvEcKQtuWyYA7yaQcTvN287YBnahIQcuSNCE2i0ekU13qH6u2GBZ5ocGCRNPUWppDLWRR19lFFf"

//    val message = Message.builder()
//        .putData("action", "LIKE")
//        .putData("content", """{
//          "userId": 1,
//          "userName": "Vasiliy",
//          "postId": 2,
//          "postAuthor": "Netology"
//        }""".trimIndent())
//        .setToken(token)
//        .build()

    val message = Message.builder()
        .putData("action", "NEW_POST")
        .putData("content", """{
          "userId": 1,
          "userName": "Konstantin",
          "postId": 2,
          "postAuthor": "NetologyK",
          "postContent": "Это текст нового поста, теоретически на несколько строк, но в одну строку)"
        }""".trimIndent())
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(message)

    println("good")
}
