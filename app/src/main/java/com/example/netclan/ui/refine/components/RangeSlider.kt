package com.example.assign.ui.screen.refine.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun RangeSliders() {
    var sliderPosition by remember { mutableStateOf(18f) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .background(Color(0xFF2A3B4C))
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Text(
                text = sliderPosition.toInt().toString(),
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 1f..100f,
            colors = SliderDefaults.colors(Color(0xFF0b395a)),
            onValueChangeFinished = {
                sliderPosition = sliderPosition.roundToInt().toFloat()
            },
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "1 Km")
            Text(text = "100 Km")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RangeSliderPrev() {
    RangeSliders()
}
