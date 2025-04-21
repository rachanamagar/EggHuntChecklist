package com.myapp.egghuntlist.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myapp.egghuntlist.R
import com.myapp.egghuntlist.ui.theme.darkBlue
import com.myapp.egghuntlist.ui.theme.gradientColor

@Composable
fun DialogueScreen(onDismiss:()-> Unit) {
    Column(
        modifier = Modifier
            .width(249.dp)
            .height(265.dp)
            .background(darkBlue, RoundedCornerShape(12.dp))
            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProgressBar()
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = " Oops, the egg rolled away!",
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.nunitoextrab))
        )

        Spacer(modifier = Modifier.height(10.dp))
        Icon(
            painter = painterResource(R.drawable.rolledegg),
            contentDescription = "Rolled Egg",
            tint = Color.Unspecified,
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .border(1.dp, Color.White, RoundedCornerShape(8.dp))
                .background(brush = gradientColor, shape = RoundedCornerShape(8.dp))
                .width(209.dp)
        ) {
            Button(
                onClick = { onDismiss()},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Dismiss",
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.nunitoextrab))
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DialogueScreenPreview() {
    DialogueScreen({})
}