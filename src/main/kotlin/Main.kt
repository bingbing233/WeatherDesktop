import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import style.colorBg
import ui.LeftFragment
import ui.RightFragment

@Composable
@Preview
fun App() {
    MaterialTheme {
        Box(modifier = Modifier.fillMaxSize().background(colorBg).padding(10.dp)) {
            Row(modifier = Modifier.fillMaxSize()) {
                // 总体概览
                LeftFragment(
                    modifier = Modifier.weight(1f).fillMaxHeight()
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                )

                Spacer(modifier = Modifier.width(10.dp))

                // 其他数据
                RightFragment(
                    modifier = Modifier.weight(1.5f).fillMaxHeight()
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                )
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Weather Compose") {
        App()
    }
}
