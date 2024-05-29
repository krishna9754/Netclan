package com.example.assign.ui.screen.explore

import BusinessesCard
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.assign.ui.screen.explore.component.ExploreCard
import com.example.assign.ui.screen.explore.component.ScaffoldBar
import com.example.assign.ui.screen.explore.component.ServiceCard
import com.example.netclan.R
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreScreen(navController: NavHostController, drawerState: DrawerState, scope: CoroutineScope) =
    ScaffoldBar(
        title = "Howdy UserName !!",
        text1 = "Location",
        navController,
    ) {
        var selectedText by remember { mutableStateOf("Personal") }

        LazyColumn(
            modifier = Modifier
                .padding(it)
        ) {
            item {
                val texts = listOf("Personal", "Service", "Businesses")

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xff143d59)),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    texts.forEach { text ->
                        Button(
                            colors = ButtonDefaults.buttonColors(Color(0xff143d59)),
                            onClick = { selectedText = text },
                            modifier = Modifier.weight(.5f)
                                .then(
                                    if (selectedText == text) {
                                        Modifier.drawWithContent {
                                            drawContent()
                                            drawLine(
                                                color = Color.White,
                                                start = Offset(0f, size.height),
                                                end = Offset(size.width, size.height),
                                                strokeWidth = 10f
                                            )
                                        }
                                    } else {
                                        Modifier
                                    }
                                )
                        ) {
                            Text(
                                text = text, modifier = Modifier,
                                fontSize = 14.sp,
                                color = if (selectedText == text) Color.White else Color(0xff8798a2)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    OutlinedTextField(
                        modifier = Modifier
                            .weight(.7f)
                            .height(50.dp),
                        value = "",
                        onValueChange = {},
                        shape = RoundedCornerShape(15.dp),
                        placeholder = { Text(text = "Search") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = ""
                            )
                        }
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.filter),
                        contentDescription = "",
                        modifier = Modifier
                            .weight(.15f)
                            .size(25.dp),
                        tint = Color(0xff224156)
                    )
                }
            }
            items(10) {
                when (selectedText) {
                    "Personal" -> ExploreCard()
                    "Service" -> ServiceCard()
                    "Businesses" -> BusinessesCard()
                }
            }
        }
    }


