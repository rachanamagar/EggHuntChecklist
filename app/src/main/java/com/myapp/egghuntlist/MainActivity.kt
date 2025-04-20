package com.myapp.egghuntlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.myapp.egghuntlist.data.locations
import com.myapp.egghuntlist.presentation.CheckListScreen
import com.myapp.egghuntlist.ui.theme.EggHuntlistTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EggHuntlistTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                 CheckListScreen(
                     locations = locations,
                     modifier = Modifier.padding(innerPadding)
                 )
                }
            }
        }
    }
}
