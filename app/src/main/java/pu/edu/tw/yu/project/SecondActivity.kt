package pu.edu.tw.yu.project

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pu.edu.tw.yu.project.ui.theme.ProjectTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting2(
                        name = "瑪利亞園丁養成記",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    val ColorTulip = Color(0xFFF1E5D1)
    val ColorStorksbill= Color(0xF2F2E2)
    val context = LocalContext.current  //取得App的運行環境
    val activity = (context as Activity)  //取得App運行的活動
    Column (modifier = Modifier
        .fillMaxSize()
        .background(ColorTulip),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row {
            Image(
                painter = painterResource(id = R.drawable.name),
                contentDescription = "圖片",
                modifier = Modifier.size(300.dp)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.head),
            contentDescription = "圖片",
            modifier = Modifier.size(300.dp)
        )

        Row {
            Row {
                Button(onClick = {
                    var it = Intent(context, ThirdActivity::class.java)
                    context.startActivity(it)
                },
                    colors = buttonColors(Color.White),
                    border = BorderStroke(1.dp, Color.Black)
                ) {
                    Image(
                        painterResource(id = R.drawable.book),
                        contentDescription ="button icon",
                        modifier = Modifier.size(50.dp)
                    )

                    Text("知識",
                        fontSize =20.sp,
                        color = Color.Black
                    )
                }
                Button(onClick = {
                    var it = Intent(context, Forth0Activity::class.java)
                    context.startActivity(it)
                },
                    colors = buttonColors(Color.White),
                    border = BorderStroke(1.dp, Color.Black)

                ) {
                    Image(
                        painterResource(id = R.drawable.diy),
                        contentDescription ="button icon",
                        modifier = Modifier.size(50.dp)
                    )
                    Text("DIY",
                        fontSize =20.sp,
                        color = Color.Black
                        )
                }
                Button(onClick = {
                    var it = Intent(context, FifthActivity::class.java)
                    context.startActivity(it)  },
                    colors = buttonColors(Color.White),
                    border = BorderStroke(1.dp, Color.Black)

                ) {
                    Image(
                        painterResource(id = R.drawable.diary),
                        contentDescription ="button icon",
                        modifier = Modifier.size(50.dp)
                    )
                    Text("日記",
                        fontSize =17.sp,
                        color = Color.Black
                        )
                }
            }

        }
    }
}

