package com.example.assignment.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.assign.ui.navigation.Rout
import com.example.assign.ui.screen.refine.components.DropDownMenu
import com.example.assign.ui.screen.refine.components.RangeSliders
import com.example.assignment.ui.components.TopAppBars
import kotlin.random.Random


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Refine(navController: NavHostController) = TopAppBars(
    title = "Refine",
    refIcon = null,

    ) {

    val purpose = listOf("Coffee", "Business", "Hobbies", "Friendship", "Movies", "Dinning", "Dating", "Matrimony")

    Column(
        modifier = Modifier
            .padding(10.dp)
            .padding(it)
    ) {
        RefineContent(purpose, navController)
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RefineContent(purpose: List<String>, navController: NavHostController) {
    var texts by remember { mutableStateOf("") }
    val selectedIndices = remember { mutableStateOf(List(2) { Random.nextInt(purpose.size) }) }
    val keyboardController = LocalSoftwareKeyboardController.current



    Text(text = "Select Your Availability", color = Color(0xff173245))
    Spacer(modifier = Modifier.padding(vertical = 4.dp))
    DropDownMenu()
    Spacer(modifier = Modifier.padding(vertical = 10.dp))
    Text(text = "Add your Status", color = Color(0xff173245))
    Spacer(modifier = Modifier.padding(vertical = 4.dp))
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = texts,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = { keyboardController?.hide()}
        ),
        onValueChange = { texts = it },
        shape = RoundedCornerShape(10.dp),
        placeholder = {
            Text(
                text = "Hi community! I am open to new connections",
                fontSize = 13.sp,
                color = Color(0xff738289)
            )
        }
    )
    Text(text = "47/250", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.End)
    Spacer(modifier = Modifier.padding(vertical = 10.dp))
    Text(text = "Select Hyper local Distance")
    Spacer(modifier = Modifier.padding(vertical = 4.dp))
    RangeSliders()
    Spacer(modifier = Modifier.padding(vertical = 10.dp))
    Text(text = "Select Purpose")
    Spacer(modifier = Modifier.padding(vertical = 4.dp))
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(purpose) { item ->
            val isSelected = purpose.indexOf(item) in selectedIndices.value
            Card(
                modifier = Modifier
                    .padding(vertical = 5.dp)
                    .clickable {
                        val index = purpose.indexOf(item)
                        if (isSelected) {
                            selectedIndices.value = selectedIndices.value - index
                        } else {
                            selectedIndices.value = selectedIndices.value + index
                        }
                    },
                border = BorderStroke(1.dp, Color.DarkGray),
                colors = CardDefaults.cardColors(if (isSelected) Color(0xFF2A3B4C) else Color.White),
            ) {
                Text(
                    text = item,
                    modifier = Modifier
                        .padding(vertical = 5.dp, horizontal = 6.dp)
                        .fillMaxWidth(),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    color = if (isSelected) Color.White else Color.Black
                )
            }
        }
    }
    Spacer(modifier = Modifier.padding(vertical = 10.dp))
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { navController.navigate(Rout.ExploreScreen.name) },
            colors = ButtonDefaults.buttonColors(Color(0xFF153d57))
        ) {
            Text(
                text = "Save & Explore",
                modifier = Modifier.padding(horizontal = 30.dp),
                fontSize = 12.sp
            )
        }
    }
}