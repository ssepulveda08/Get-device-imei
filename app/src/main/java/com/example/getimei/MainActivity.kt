package com.example.getimei

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.getimei.ui.theme.GetImeiTheme
import com.example.getimei.ui.theme.Typography
import com.example.getimei.utils.getDeviceID

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GetImeiTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val imei = getDeviceID(baseContext)
                    val name = " ${Build.MANUFACTURER} ${Build.MODEL},${imei} "
                    Greeting(name)
                }
            }
        }
    }
}

@Composable
fun Greeting(imei: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.subtitle2,
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 18.sp
                    )
                ) {
                    append("The imei of this device is: \n\n\n")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Medium,
                    )
                ) {
                    append(imei)
                }
            }
        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GetImeiTheme {
        Greeting("jkhkjhsadkjh")
    }
}