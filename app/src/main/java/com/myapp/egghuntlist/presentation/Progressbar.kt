package com.myapp.egghuntlist.presentation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myapp.egghuntlist.R
import com.myapp.egghuntlist.ui.theme.orange
import com.myapp.egghuntlist.ui.theme.orangeBg
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@Composable
fun ProgressBar() {

    val duration = 4000L
    val progress = remember { Animatable(1f) }
    var timeLeft by remember { mutableStateOf(duration / 1000) }

    LaunchedEffect(Unit) {
        launch {
            progress.animateTo(
                targetValue = 0f,
                animationSpec = tween(
                    durationMillis = duration.toInt()
                )
            )
        }
        launch {
            for (i in timeLeft downTo 0) {
                timeLeft = i
                delay(1000L)
            }
        }

    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        LinearProgressIndicator(
            progress = { progress.value },
            modifier = Modifier
                .weight(2f)
                .padding(10.dp)
                .height(6.dp),
            color = orange,
            trackColor = orangeBg
        )

        Text(
            text = "${timeLeft}s",
            color = orange,
            fontSize = 18.sp,
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily(Font(R.font.nunitoextrab)),
            modifier = Modifier
                .padding(5.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProgressBarPreview() {
    ProgressBar()
}