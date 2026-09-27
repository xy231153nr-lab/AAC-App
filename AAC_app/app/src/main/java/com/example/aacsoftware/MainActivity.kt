package com.example.aacsoftware

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.aacsoftware.ui.theme.AACSoftwareTheme
data class AacButton(val id: String, val icon: String, val label: String, val spokenText: String=label,val backGroundColor: Color= Color(0xFFFFFFFF))
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AACSoftwareTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CommunicationBoard(null, )
                }
            }
        }
    }
}
@Composable
fun CommunicationBoard(
    buttons: list<AacButton>,
    onButtonPressed: (AacButton)-> Unit
)
{
    LazyVerticalGrid(columns = GridCells.fixed(3), modifier = Modifier.fillMaxSize().padding(12.dp), horizontalArrangement = Arrangement.spacedBy(12.dp), verticalArrangement = Arrangement.spacedBy(12.dp))
    {
        items(items = buttons,key={it.id})
        {
            button(onClick={onButtonPressed(button)})
        }
    }
}
