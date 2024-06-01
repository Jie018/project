package pu.edu.tw.yu.project

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextInputService
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pu.edu.tw.yu.project.ui.theme.ProjectTheme

class ThirdActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting3(
                        name = "想知道更多植物",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {
    val ColorTulip = Color(0xFFF1E5D1)
    val context = LocalContext.current  //取得App的運行環境
    val activity = (context as Activity)  //取得App運行的活動
    var Plants = arrayListOf(
        R.drawable.basil, R.drawable.bay,
        R.drawable.peppermint, R.drawable.rosemary,
        R.drawable.thyme, R.drawable.verbena
    )

    var PlantsName = arrayListOf(
        "羅勒:保護神經系統、增強抵抗力、穩定血糖、維護腸道健康。",
        "月桂葉:加速傷口愈合、緩解胃腸不適。：減輕由壓力和酒精引起的胃部不適、調節餐後血糖。",
        "綠薄荷:消炎鎮痛、增強抵抗力、提振精神、調理腸道。",
        "迷迭香:保護神經系统、维護腸胃健康、降低感冒風險、促進新陳代谢。",
        "百里香:預防呼吸道疾病、保護肝臟、抑制細菌生長。",
        "馬鞭草:鬆弛神經、安神舒壓、舒緩情緒等作用。"
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
                        activity.finish()
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

        LazyColumn {
            items(6) { index ->
                Text(text = PlantsName[index % 10])
                Text(text = index.toString())
                Image(
                    painter = painterResource(id = Plants[index % 10]),
                    contentDescription = "植物圖片"
                )
            }
        }
    }

}

