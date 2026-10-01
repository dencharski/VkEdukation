package com.example.vkedukationapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkedukationapplication.ui.theme.VkEdukationApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VkEdukationApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    companion object {
        final const val KEY: String = "key"
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    val message = remember { mutableStateOf("") }
    val context = LocalContext.current
    var phoneNumber by remember { mutableStateOf(TextFieldValue("")) }

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

        Button(onClick = {
            if (message.value.isNotEmpty()) {
                val intent = Intent(context, MainActivity2::class.java)
                intent.putExtra(MainActivity.KEY, message.value)
                context.startActivity(intent)
            }

        }) {
            Text("Открыть вторую Activity", fontSize = 25.sp)
        }

        Button(onClick = {
            if (message.value.isNotEmpty()) {
                val sendIntent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, message.value)
                }

                val chooser = Intent.createChooser(sendIntent, "Поделиться через…")
                context.startActivity(chooser)
            }
        }) {
            Text("Поделиться текстом")
        }




        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Номер телефона") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val number = phoneNumber.text.trim()
                if (number.isNotEmpty()) {
                    val intent = Intent(Intent.ACTION_DIAL).apply {
                        data = Uri.parse("tel:\$number")
                    }
                     if (intent.resolveActivity(context.packageManager) != null) {
                        context.startActivity(intent)
                    }
                }
            },

            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Набрать номер")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VkEdukationApplicationTheme {
        Greeting("Android")
    }
}