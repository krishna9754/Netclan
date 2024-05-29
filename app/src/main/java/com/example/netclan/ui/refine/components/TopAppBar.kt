package com.example.assignment.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBars(
    title: String,
    icon: ImageVector? = Icons.Default.KeyboardArrowLeft,
    refIcon: ImageVector? = Icons.Default.KeyboardArrowLeft,
    onBack: () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    containerColor: Color = MaterialTheme.colorScheme.background,
    appBarColor: TopAppBarColors = TopAppBarDefaults.topAppBarColors(Color(0xFF143d59)),
    content: @Composable (PaddingValues) -> Unit = {}
) {
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
                        Text(
                            text = title,
                            color = Color.White,
                        )
                        if (refIcon != null ) {
                            Icon(
                                imageVector = refIcon,
                                contentDescription = "Menu",
                                tint = Color.White
                            )
                        }
                    }
                },

                navigationIcon = {
                    if (icon != null) {
                        IconButton(onClick = onBack) {
                            Icon(
                                imageVector = icon,
                                contentDescription = "Menu",
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