package com.example.assign.ui.screen.refine.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenu(){
    var expanded by remember { mutableStateOf(false) }
    val list = listOf("Away | Stay Discrete And Watch", "Busy | Do Not Disturb | Will Catch Up Later", "SOS | Emergency! Need Assistance! HELP")
    var selectText by remember { mutableStateOf(list[0]) }


    Card(
        modifier = Modifier
            .fillMaxWidth()
//            .padding(horizontal = 8.dp)
            .border(width = 1.dp, color = Color(0xff123e59), shape = RoundedCornerShape(10.dp)),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        ExposedDropdownMenuBox(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White),
            expanded = expanded,
            onExpandedChange = {expanded = !expanded}
        ) {
            TextField(
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .background(color = Color.White),
                value = selectText,
                onValueChange = {},
                readOnly = true,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    disabledIndicatorColor = Color.Transparent
                ),
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)}
            )

            ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                list.forEachIndexed { index, text ->

                    DropdownMenuItem(
                        colors = MenuDefaults.itemColors(Color(0xff738289)),
                        modifier = Modifier.fillMaxWidth(),
                        text = { Text(text = text, fontSize = 14.sp) },
                        onClick = {
                            selectText = list[index]
                            expanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PrecD(){
    DropDownMenu()
}