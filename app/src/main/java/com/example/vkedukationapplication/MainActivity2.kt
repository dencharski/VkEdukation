package com.example.vkedukationapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkedukationapplication.ui.theme.VkEdukationApplicationTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val receivedString = intent.getStringExtra(MainActivity.KEY) ?: "Значение по умолчанию"
            VkEdukationApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting2(
                        name = receivedString,
                        modifier = Modifier.padding(innerPadding)
                    )
                }

            }
        }
    }

}
@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {

    val message = remember { mutableStateOf("") }

    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        TextField(
            value = message.value,
            textStyle = TextStyle(fontSize = 25.sp),
            onValueChange = { newText -> message.value = newText }
        )


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    VkEdukationApplicationTheme {
        Greeting2("Android")
    }
}