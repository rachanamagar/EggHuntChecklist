package com.myapp.egghuntlist.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myapp.egghuntlist.R
import com.myapp.egghuntlist.data.EggHunt
import com.myapp.egghuntlist.data.locations
import com.myapp.egghuntlist.ui.theme.darkBlue
import com.myapp.egghuntlist.ui.theme.orange
import com.myapp.egghuntlist.ui.theme.orangeLight
import kotlinx.coroutines.delay

@Composable
fun CheckListScreen(locations: List<EggHunt>, modifier: Modifier) {

    var checkState by remember { mutableStateOf(List(locations.size) { false }) }
    var selectedIndex by remember { mutableStateOf<Int?>(null) }
    var showDialogue by remember { mutableStateOf(false) }
    var isLocationChecked by remember { mutableStateOf(false) }

    val eggsFound = checkState.count { it }

    LaunchedEffect(showDialogue) {
        delay(4000)
        showDialogue = false
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxSize()
            .background(darkBlue)
            .padding(start = 20.dp, end = 20.dp, top = 40.dp, bottom = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Egg Hunt Checklist",
            fontSize = 24.sp,
            color = orange,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.nunitoextrab))
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Pick locations, where you’ve \n found eggs",
            fontSize = 20.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.nunitoextrab))

        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "$eggsFound/${locations.size} eggs found",
            fontSize = 14.sp,
            color = orangeLight,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.nunitoblack))
        )
        Spacer(modifier = Modifier.height(20.dp))

        Column(modifier = Modifier.height(580.dp)) {
            LazyColumn(
                state = rememberLazyListState(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                itemsIndexed(locations) { index, item ->
                    ListItem(
                        location = item.locations,
                        isChecked = checkState[index],
                        toggleBox = {
                            checkState = checkState.toMutableList().also {
                                it[index] = !it[index]
                            }
                            isLocationChecked = checkState[index]
                            showDialogue = true

                        },
                        onClicked = {
                            selectedIndex = index
                        }

                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }

        Button(
            onClick = {
                checkState = List(locations.size) { false }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = orange
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = "Reset", fontSize = 14.sp,
                modifier = Modifier
                    .padding(4.dp),
                fontWeight = FontWeight.Bold
            )
        }
    }
    if (showDialogue) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.4f)),
            contentAlignment = Alignment.Center
        ) {
            if (isLocationChecked) {
                FactDialogue(
                    onDismiss = {
                        isLocationChecked = false
                        showDialogue = false
                    }
                )
            } else {
                DialogueScreen(
                    onDismiss = {
                        isLocationChecked = false
                        showDialogue = false
                    }
                )
            }
        }
    }
}

@Composable
fun ListItem(
    location: String,
    isChecked: Boolean,
    toggleBox: () -> Unit,
    onClicked: () -> Unit
) {

    val backgroundColor = if (isChecked) orange else Color.Gray.copy(00.7f)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor, RoundedCornerShape(10.dp))
            .padding(5.dp)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()

        ) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = { toggleBox() },
                colors = CheckboxDefaults.colors(
                    checkmarkColor = Color.Black,
                    disabledUncheckedColor = Color.White,
                    disabledCheckedColor = Color.White,
                    checkedColor = Color.White,
                    uncheckedColor = Color.White
                ),
                modifier = Modifier.clickable { onClicked() }
            )

            Text(
                text = location,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListItemScreenPreview() {
    ListItem("Behind the TV stand", true, {}) {}
}

@Preview(showBackground = true)
@Composable
fun ListPreview() {
    CheckListScreen(locations = locations, modifier = Modifier)
}