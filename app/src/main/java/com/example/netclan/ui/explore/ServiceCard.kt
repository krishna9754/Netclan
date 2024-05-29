package com.example.assign.ui.screen.explore.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assign.ui.screen.explore.ExploreScreen

@Composable
fun FloatingButton(){
    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                containerColor = Color.White,
                text = {},
                icon = { Icon(Icons.Filled.Add, contentDescription = null) },
                onClick = {}
            )
        },
        content = { contentPadding ->
            ServiceCard()
        }
    )
}

@Composable
fun ServiceCard(){
    Box(modifier = Modifier
        .padding(vertical = 10.dp, horizontal = 8.dp)
        .background(color = Color.White)
    ) {
        Text(
            text = "AC",
            modifier = Modifier
                .background(color = Color(0xffb8c5cd), shape = RoundedCornerShape(10.dp))
                .padding(11.dp),
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xff113e5c)
        )
        Column(
            modifier = Modifier
                .padding(start = 30.dp, top = 3.dp)
                .border(width = 1.dp, color = Color(0xffb8c5cd), shape = RoundedCornerShape(10.dp))
        ) {
            Row(
                modifier = Modifier
                    .padding(start = 55.dp, end = 20.dp, top = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Achint Chugh",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    color = Color(0xff22333d)
                )
                EditText(text = "INVITE", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            }
            Column(
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                Text(
                    text = "Panipat, within 4.9 KM",
                    modifier = Modifier.padding(start = 36.dp, top = 2.dp),
                    color = Color(0xff445e6d),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    LinearProgressIndicator(
                        modifier = Modifier
                            .width(100.dp)
                            .padding(start = 36.dp, top = 3.dp),
                        progress = .25f,
                        color = Color(0xff74838f),
                        strokeCap = StrokeCap.Square
                    )
                    Text(text = "Profile Score - 18%", fontSize = 12.sp, color = Color(0xff7c8489))
                }
                Row(modifier = Modifier.padding(start = 36.dp, top = 3.dp), horizontalArrangement = Arrangement.spacedBy(15.dp)) {
                    Icon(imageVector = Icons.Default.Phone, contentDescription = "")
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "")
                }
                Row(
                    modifier = Modifier.padding(top = 5.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(text = "Web Developer |", fontSize = 12.sp, color = Color(0xff4e6273), fontWeight = FontWeight.SemiBold)
                    Text(text = "1 years of experience", fontSize = 12.sp, color = Color(0xff4e6273), fontWeight = FontWeight.SemiBold)
                }
                Text(
                    text = "Hi community! I am open to new connections",
                    modifier = Modifier.padding(top = 5.dp, bottom = 10.dp),
                    color = Color(0xff4e616f),
                    fontSize = 13.sp
                )
            }
        }
    }
}


@Preview
@Composable
fun PrevService(){
    FloatingButton()
}