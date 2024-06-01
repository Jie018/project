package pu.edu.tw.yu.project

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import pu.edu.tw.yu.project.ui.theme.ProjectTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.foundation.layout.Column

import androidx.compose.material3.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectTheme {
                //Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //Greeting(
                            //name = "瑪利亞園丁養成記",
                            //modifier = Modifier.padding(innerPadding)
                    //)
                    FirstScreen()
                }
            }
        }
    }

@Composable
fun FirstScreen(){
    val ColorTulip = Color(0xFFF1E5D1)
    val ColorBrown = Color(0x6F4E37)
    val ColorLime = Color(0xBEB334)
    val context = LocalContext.current  //取得App的運行環境
    var appear by remember { mutableStateOf(true) }  //背景出現
    //角度動畫
    val buttonAngle by animateFloatAsState(
        if (appear) 360f else 0f,
        animationSpec = tween(durationMillis = 2500)
    )

    Column(modifier = Modifier
        .fillMaxSize()
        .background(ColorTulip),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Image(
            painter = painterResource(id = R.drawable.name),
            contentDescription = "圖片",
            modifier = Modifier.size(300.dp)
        )
        AnimatedVisibility(
            visible = appear,
            enter = fadeIn(
                initialAlpha = 0.1f,
                animationSpec = tween(durationMillis = 5000))
                    + slideInHorizontally(
                animationSpec = tween(durationMillis = 5000)) { fullWidth ->
                fullWidth / 3
            },
            exit = fadeOut(
                animationSpec = tween(durationMillis = 5000))
                    + slideOutHorizontally(
                animationSpec = tween(durationMillis = 5000)) { fullWidth ->
                fullWidth / 3
            }


        ) {

            Image(
                painter = painterResource(id = R.drawable.logo2),
                contentDescription = "圖片",
                modifier = Modifier.size(400.dp)
            )
        }
        Button(onClick = {appear = !appear
            var it = Intent(context, SecondActivity::class.java)
            context.startActivity(it)
        },
            colors = ButtonDefaults.buttonColors(ColorLime),
            border = BorderStroke(1.dp, Color.DarkGray)

            //modifier = Modifier.rotate(buttonAngle)
        )
        {
            Text(text = "GO!",
                fontSize = 30.sp,
                color = Color.Black
            )
        }

    }
}


