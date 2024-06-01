package pu.edu.tw.yu.project

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pu.edu.tw.yu.project.ui.theme.ProjectTheme

class Forth4Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting44(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting44(name: String, modifier: Modifier = Modifier) {
    val ColorTulip = Color(0xFFF1E5D1)
    val context = LocalContext.current  //取得App的運行環境
    val activity = (context as Activity)  //取得App運行的活動
    Column {
        var appear by remember { mutableStateOf(true) }  //背景出現

        //角度動畫
        val buttonAngle by animateFloatAsState(
            if (appear) 360f else 0f,
            animationSpec = tween(durationMillis = 2500)
        )
        //顏色動畫
        val backgroundColor by animateColorAsState(
            if (appear) Color.Transparent else Color.Green,
            animationSpec = tween(2000, 500)
        )
        Column (modifier = Modifier
            .fillMaxSize()
            .background(ColorTulip),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Column {
                Button(
                    onClick = { appear = !appear },
                    colors = ButtonDefaults.buttonColors(Color.LightGray),
                    border = BorderStroke(1.dp, Color.Black)
                    //modifier = Modifier.rotate(buttonAngle)
                ) {
                    if (appear) Text(text = "花盆消失",
                        fontSize = 20.sp,
                        color = Color.Black)
                    else Text(text = "花盆出現",
                        fontSize = 20.sp,
                        color = Color.Black)
                }
            }
            AnimatedVisibility(
                visible = appear,
                enter = fadeIn(
                    initialAlpha = 0.1f,
                    animationSpec = tween(durationMillis = 3000)
                )
                        + slideInHorizontally(
                    animationSpec = tween(durationMillis = 3000)
                ) { fullWidth ->
                    fullWidth / 3
                },
                exit = fadeOut(
                    animationSpec = tween(durationMillis = 3000)
                )
                        + slideOutHorizontally(
                    animationSpec = tween(durationMillis = 3000)
                ) { fullWidth ->
                    fullWidth / 3
                }


            ) {
                Column (modifier = Modifier
                    .fillMaxSize()
                    .background(ColorTulip),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){

                    Image(
                        painter = painterResource(id = R.drawable.grow),
                        contentDescription = "花盆背景圖",
                        modifier = Modifier.size(300.dp)

                    )
                    Text(text = "幼苗",
                        fontSize = 30.sp,
                        color = Color.Blue
                    )

                }



            }
            Button(onClick = {appear = !appear
                var it = Intent(context, Forth5Activity::class.java)
                context.startActivity(it)
            },
                colors = ButtonDefaults.buttonColors(Color.Transparent)
                //modifier = Modifier.rotate(buttonAngle)
            )
            {
                Text(text = "下一步",
                    fontSize = 20.sp,
                    color = Color.Black

                )
            }

        }
    }

    Row {
        Button(

            onClick = {
                var it = Intent(context, Forth3Activity::class.java)
                context.startActivity(it)
            },
            colors = ButtonDefaults.buttonColors(ColorTulip)
        )
        {
            Image(
                painterResource(id = R.drawable.flower),
                contentDescription = "button icon",
                modifier = Modifier.size(80.dp),

                )

        }
    }
}