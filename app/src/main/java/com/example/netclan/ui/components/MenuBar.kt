package com.example.assignment.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.assign.ui.screen.explore.ExploreScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MenuBar(navController: NavHostController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(310.dp),
                drawerContainerColor = Color(0xff0e2e43)
            ) {
                MenuItem(scope, drawerState)
            }
        }
    ) {
        Scaffold(
//            floatingActionButton = {
//                ExtendedFloatingActionButton(
//                    containerColor = Color.White,
//                    text = {},
//                    icon = { Icon(Icons.Filled.Add, contentDescription = null) },
//                    onClick = {}
//                )
//            },
            content = { contentPadding ->
                ExploreScreen(navController = navController, drawerState, scope)
            }
        )
    }
}

@Composable
fun MenuItem(scope: CoroutineScope, drawerState: DrawerState) {
    val selectItem = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Card(shape = RoundedCornerShape(1.dp), colors = CardDefaults.cardColors(Color(0xff2596be))) {
            Row(
                modifier = Modifier
                    .padding(top = 10.dp, start = 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "",
                    modifier = Modifier
                        .background(color = Color.White, shape = CircleShape)
                        .size(80.dp)
                        .padding(10.dp)
                )
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "",
                    modifier = Modifier.padding(top = 20.dp, end = 10.dp)
                )
            }
            Column(modifier = Modifier.padding(start = 20.dp, top = 10.dp)) {
                Text(text = "User Name", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                Text(text = "Uswgdffg", fontSize = 14.sp, color = Color.White)
                LinearProgressIndicator(
                    modifier = Modifier
                        .width(100.dp)
                        .size(15.dp)
                        .padding(top = 4.dp),
                    progress = .25f,
                    color = Color.White,
                    strokeCap = StrokeCap.Round
                )
                Text(text = "Away", modifier = Modifier.padding(vertical = 5.dp), fontSize = 12.sp, color = Color.White)
            }
        }
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Column(
            modifier = Modifier
                .background(color = Color.White), verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            val MenuList = listOf("My Profile", "My Network", "Switch to Service", "Switch to Businesses", "Dating", "Matrimony", "Buy-Sell-Rent", "Jobs", "Business Cards", "Netclan Groups", "Notes", "Live Locations")

            MenuList.forEachIndexed { index, item ->
                val backgroundColor =
                    if (selectItem.value == index) Color(0xffe2e7eb) else Color.White

                Row(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .clickable { scope.launch { drawerState.close() } }
                        .fillMaxWidth()
                        .background(color = backgroundColor, shape = RoundedCornerShape(5.dp)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(3.dp)
                            .size(30.dp)
                    )
                    Text(
                        text = item,
                        modifier = Modifier,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xff1f3745)
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun MenuBarP() {
    MenuBar(navController = rememberNavController())

}

@Preview(showBackground = true)
@Composable
fun MenuBarPr() {
    MenuItem(
        scope = rememberCoroutineScope(),
        drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    )
}