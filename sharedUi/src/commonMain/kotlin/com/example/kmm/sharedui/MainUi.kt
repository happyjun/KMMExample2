package com.example.kmm.sharedui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

/**
 * 类功能描述: 主页面
 *
 * @date 2022/8/9
 */


/**
 * 主UI入口
 */
@Composable
fun MainUi() {
    MaterialTheme {
        MainLazyColumnItemsList()
    }
}

@Composable
fun MainLazyColumnItemsList() {
    LazyColumn(modifier = Modifier.fillMaxHeight().padding(5.dp)) {
        items(count = 20) { index ->
            Box(
                modifier = Modifier.fillMaxWidth().height(290.dp)
                    .padding(start = 8.dp, end = 8.dp, top = 10.dp)
                    .clip(RoundedCornerShape(4.dp)),
                contentAlignment = Alignment.BottomStart
            ) {
                Image(
                    painter = ColorPainter(Color.Gray),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = "Sample",
                    alignment = Alignment.Center,
                    modifier = Modifier.fillMaxWidth().height(290.dp)
                        .padding(bottom = 60.dp)
                        .clip(RoundedCornerShape(4.dp))
                )
            }
        }
    }
}