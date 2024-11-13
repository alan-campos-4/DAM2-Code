package com.example.application1

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
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
import com.example.application1.ui.theme.Application1Theme

class MainActivity : ComponentActivity() {
    companion object{
        const val LIFELICE = "PruebaActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Log.d(LIFELICE, "Entro en onCreate")
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener() {
            val sendIntent = Intent().apply{
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Mi primer correo")
                type = "text/plain"
            }
            try {
                startActivity(sendIntent)
            }catch (e:ActivityNotFoundException){
                println("Error")
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(LIFELICE, "Entro en onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.d(LIFELICE, "Entro en onResumen")
    }
    override fun onPause() {
        super.onPause()
        Log.d(LIFELICE, "Entro en onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d(LIFELICE, "Entro en onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(LIFELICE, "Entro en onDestroy")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Application1Theme {
        Greeting("Android")
    }
}