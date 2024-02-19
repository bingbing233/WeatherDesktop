package ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LeftFragment(modifier: Modifier) {
    Box(modifier = modifier.padding(horizontal = 20.dp, vertical = 15.dp)) {
        Row(modifier = Modifier.fillMaxWidth().height(20.dp)) {
            // 添加城市按钮
            Icon(imageVector = Icons.Default.Add, "")
            Spacer(modifier = Modifier.width(10.dp))
            // 当前城市
            Text("广州")
            // 撑满剩余空间
            Spacer(modifier = Modifier.weight(1f,true))
            // 时间
            Text("16:10")
            Spacer(modifier = Modifier.width(10.dp))
            Icon(imageVector = Icons.Default.Refresh, "")

        }

    }
}