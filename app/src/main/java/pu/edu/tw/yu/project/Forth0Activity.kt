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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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

class Forth0Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting40(
                        name = "動手試試看吧",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting40(name: String, modifier: Modifier = Modifier) {
    val ColorTulip = Color(0xFFF1E5D1)
    val context = LocalContext.current  //取得App的運行環境
    val activity = (context as Activity)  //取得App運行的活動
    var Plants = arrayListOf(
        R.drawable.soil, R.drawable.seed,
        R.drawable.can, R.drawable.seedling,
        R.drawable.grow, R.drawable.grass,R.drawable.fin
    )

    var PlantsName = arrayListOf(
        "挖洞",
        "放種子",
        "澆水",
        "幼芽",
        "幼苗",
        "成長",
        "成功啦!"
    )



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorTulip),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            Row {

                Button(
                    onClick = {
                        var it = Intent(context, SecondActivity::class.java)
                        context.startActivity(it)
                    },
                    colors = ButtonDefaults.buttonColors(ColorTulip)
                )

                {
                    Image(
                        painterResource(id = R.drawable.head),
                        contentDescription = "button icon",
                        modifier = Modifier.size(80.dp),

                        )

                }
                Text(
                    text = "$name!",
                    fontSize = 30.sp
                )
            }
        }

        LazyRow {
            items(7) { index ->
                Text(text = PlantsName[index % 10])
                Text(text = index.toString())
                Image(
                    painter = painterResource(id = Plants[index % 10]),
                    contentDescription = "植物圖片"
                )
            }
        }
        Button(
            onClick = {
                var it = Intent(context, ForthActivity::class.java)
                context.startActivity(it)
            },
            colors = ButtonDefaults.buttonColors(ColorTulip),
            border = BorderStroke(1.dp, Color.DarkGray)
        )

        {
            Text(text = "Start!",
                fontSize = 30.sp,
                color = Color.Black)
        }
    }

}
