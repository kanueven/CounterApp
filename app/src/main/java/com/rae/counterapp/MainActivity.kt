package com.rae.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rae.counterapp.ui.theme.CounterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterApp()

                }
            }
        }
    }
}

@Composable
fun CounterApp(modifier: Modifier = Modifier){
    //count value starts at 3,so we initialize it
    val currentCount = remember { mutableStateOf(3) }
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
        modifier = modifier

            .padding(16.dp)
    ) {
        //ImageSection
        Image(
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 40.dp),
            painter = painterResource(id = R.drawable.ic_android_black_24dp),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        //Count section

        Text(text = "Current count : ${currentCount.value}",
            fontSize = 14.sp,

            modifier = Modifier.padding(12.dp)
        )
        //Owner section
        Text(text = "Amin Samatar (CS 492)",
            fontSize = 14.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
          modifier = Modifier.padding(8.dp)
        )


        //Buttons section
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ){
            Button(
                onClick = {
                    //check the the current value
                    val newCount = currentCount.value
                    //current value decrements by
                    if (newCount > 1) {
                        currentCount.value -= 1
                    }
                    //if it goes below 1 reset to 5
                    else{
                        currentCount.value = 5
                     }
                },colors = ButtonDefaults.buttonColors(

                    contentColor = Color.White
                )
                ) {
                Text(text = "Previous")
            }
            Button(
                onClick = {
                    //check the the current value
                    val newCount = currentCount.value
                    //current value increments by 1
                    if (newCount < 5) {
                        currentCount.value += 1
                    }
                    //if it goes over 5 reset to 1
                    else{
                        currentCount.value = 1
                    }
                },
        colors = ButtonDefaults.buttonColors(

        contentColor = Color.White
        )
            ) {
                Text(text = "Next")
            }
        }

    }

}

@Preview
@Composable
fun CounterAppPreview(){
    CounterApp()

}

