package com.example.assign.ui.screen.explore.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.assign.ui.navigation.Rout
import com.example.netclan.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldBar(
    title: String? = null,
    text1: String? = null,
    navController: NavHostController,
    icon: Int = R.drawable.menu,
    refIcon: Int = R.drawable.settings,
    onBack: () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    containerColor: Color = MaterialTheme.colorScheme.background,
    appBarColor: TopAppBarColors = TopAppBarDefaults.topAppBarColors(Color(0xFF0e2e43)),
    content: @Composable (PaddingValues) -> Unit = {},
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    Scaffold(
        containerColor = containerColor,
        topBar = {
            TopAppBar(
                colors = appBarColor,
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            if (title != null) {
                                Text(
                                    text = title,
                                    color = Color.White,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 14.sp
                                )
                            }
                            if (text1 != null) {
                                EditText(
                                    text = text1,
                                    icon = Icons.Default.LocationOn,
                                    fontSize = 12.sp,
                                    color = Color.White
                                )
                            }
                        }
                        Column(
                            modifier = Modifier.clickable { navController.navigate(Rout.RefineScreen.name) }
                        ) {
                            if (refIcon != null) {
                                Icon(
                                    painter = painterResource(id = refIcon),
                                    contentDescription = "",
                                    modifier = Modifier.size(25.dp),
                                    tint = Color.White
                                )
                            }
                            Text(text = "Refine", color = Color.White, fontSize = 13.sp)
                        }

                    }
                },

                navigationIcon = {
                    if (icon != null) {
                        IconButton(onClick = {
                            scope.launch {
                                if (drawerState.isClosed) drawerState.open() else drawerState.close()
                            }
                        }) {
                            Icon(
                                painter = painterResource(id = icon),
                                contentDescription = "Menu",
                                modifier = Modifier
                                    .size(38.dp),
                                tint = Color.White
                            )
                        }
                    }
                }
            )
        },
        bottomBar = bottomBar,
        content = content
    )
}