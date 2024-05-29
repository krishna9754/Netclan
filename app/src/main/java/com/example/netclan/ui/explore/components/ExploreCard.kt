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
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ExploreCard() {
    val currentProgress by remember { mutableStateOf(.25f) }
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
                    text = "Panipat | Deve",
                    modifier = Modifier.padding(start = 36.dp, top = 4.dp),
                    color = Color(0xff445e6d),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Within 1.7 KM",
                    modifier = Modifier.padding(start = 36.dp, top = 4.dp),
                    color = Color(0xff7c8489),
                    fontSize = 13.sp,
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    LinearProgressIndicator(
                        modifier = Modifier
                            .width(100.dp)
                            .padding(start = 36.dp, top = 3.dp),
                        progress = currentProgress,
                        color = Color(0xff74838f),
                        strokeCap = StrokeCap.Square
                    )
                    Text(text = "Profile Score - 18%", fontSize = 12.sp, color = Color(0xff7c8489))
                }
                Row(
                    modifier = Modifier.padding(top = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(text = "Coffee   |", fontSize = 12.sp, color = Color(0xff2c261b))
                    Text(text = "Business   |", fontSize = 12.sp, color = Color(0xff603340))
                    Text(text = "Friendship", fontSize = 12.sp, color = Color(0xff9b8a50))
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

@Preview(showBackground = true)
@Composable
fun ExploreCardPrev() {
    ExploreCard()
}