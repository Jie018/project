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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pu.edu.tw.yu.project.ui.theme.ProjectTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.material3.Button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore


class FifthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting5(
                        name = "心情紀錄本",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting5(name: String, modifier: Modifier = Modifier) {
    val ColorTulip = Color(0xFFF1E5D1)
    val context = LocalContext.current  //取得App的運行環境
    val activity = (context as Activity)  //取得App運行的活動
    var userName by remember { mutableStateOf(" ")}
    var userFeel by remember { mutableStateOf(" ")}
    var userDate by remember { mutableStateOf(" ")}
    var userWeather by remember { mutableStateOf(" ")}
    var userWord by remember { mutableStateOf(" ")}
    val db = Firebase.firestore



    Column (modifier = Modifier
        .fillMaxSize()
        .background(ColorTulip),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Text(
                text = "$name!",
                fontSize = 30.sp
            )
        }
        TextField(
            value = userName,
            onValueChange = { newText ->
                userName = newText
            },
            label = { Text("班級/姓名") },
            placeholder = { Text("請輸入您的班級/姓名") }

        )
        TextField(
            value = userDate,
            onValueChange = { newText ->
                userDate = newText
            },
            label = { Text("日期") },
            placeholder = { Text("請輸入今天日期") }

        )
        TextField(
            value = userWeather,
            onValueChange = { newText ->
                userWeather = newText
            },
            label = { Text("天氣") },
            placeholder = { Text("請輸入今天天氣") }

        )
        TextField(
            value = userFeel,
            onValueChange = { newText ->
                userFeel = newText
            },
            label = { Text("心情") },
            placeholder = { Text("請輸入您今日心情") }

        )
        TextField(
            value = userWord,
            onValueChange = { newText ->
                userWord = newText
            },
            label = { Text("對今天的自己說一句話") },
            placeholder = { Text("請輸入今日話語") }

        )



        Text("輸入的班級/姓名是：$userName \n" +
                "今日日期為：$userDate\n" +
                "今日天氣為：$userWeather\n" + "今日心情為：$userFeel\n "+
                "今日話語為：$userWord")
        Row {
            Button(onClick = {
                val user = Person(userName,userDate,userWeather, userFeel,userWord)
                db.collection("users")
                    //.add(user)
                    .document(userName)
                    .set(user)
                    .addOnSuccessListener { documentReference ->
                        var msg = "新增/異動資料成功"
                    }
                    .addOnFailureListener { e ->
                        var msg = "新增/異動資料失敗：" + e.toString()
                    }

            }) {
                Text("新增/修改資料")
            }
        }
    }
    Row{
        Button(
            onClick = {
                activity.finish()
            },
            colors = ButtonDefaults.buttonColors(ColorTulip)
            )
        {
            Image(
                painterResource(id = R.drawable.head),
                contentDescription ="button icon",
                modifier = Modifier.size(80.dp),

            )

        }
    }

}
data class Person(
    var userName: String,
    var userDate: String,
    var userWeather: String,
    var userFeel: String,
    var userWord: String
)

