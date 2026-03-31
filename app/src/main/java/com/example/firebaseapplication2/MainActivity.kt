package com.example.firebaseapplication2

import android.content.ContentValues.TAG
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.firebaseapplication2.ui.theme.FirebaseApplication2Theme
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirebaseApplication2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Vijay",
                        modifier = Modifier.padding(innerPadding)


                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )

    FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
        if (!task.isSuccessful) {
            Log.w("FCM_TOKEN", "Fetching FCM registration token failed", task.exception)
            return@addOnCompleteListener
        }

        val token = task.result
        Log.d("FCM_TOKEN", "Current token: $token")
    }





}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirebaseApplication2Theme {
        Greeting("Android")
    }
}