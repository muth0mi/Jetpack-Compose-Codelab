package io.muth0mi.bruh

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Model
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.CrossAxisAlignment
import androidx.ui.layout.Spacing
import androidx.ui.material.Button
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Surface
import androidx.ui.material.themeTextStyle
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreenContent()
            }
        }
    }
}

@Composable
fun MyApp(child: @Composable() () -> Unit) {
    CustomTheme {
        Surface() {
            child()
        }
    }
}

@Composable
fun MyScreenContent() {
    Column(crossAxisAlignment = CrossAxisAlignment.Center) {
        Column(crossAxisAlignment = CrossAxisAlignment.Center, modifier = Flexible(1f)) {
            Greeting("Oly!")
//            Divider(color = Color.Black)
//            Greeting("There")
            Divider(color = Color.Transparent, height = 32.dp)
        }
        Counter(CounterState(), { Log.e("MyScreenContent", "The counter button was clicked") })
        Divider(color = Color.Transparent, height = 32.dp)
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        modifier = Spacing(24.dp),
        style = +themeTextStyle { h1 }
    )
}

@Composable
fun Counter(state: CounterState, afterClick: () -> Unit) {
    Button(
        text = "I have been clicked ${state.count} times",
        onClick = { state.count++; afterClick() }
    )
}

@Preview
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreenContent()
    }
}


