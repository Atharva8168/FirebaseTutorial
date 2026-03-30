package com.example.firebaseapplication2


import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("FCM_TOKEN", token)
        android.util.Log.d("FCM_TOKEN", "Token = $token")
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        Log.d("FCM", "From: ${remoteMessage.from}")
        Log.d("FCM", "Title: ${remoteMessage.notification?.title}")
        Log.d("FCM", "Body: ${remoteMessage.notification?.body}")
    }
}