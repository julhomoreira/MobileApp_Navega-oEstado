package com.stackmobile.ca6source72396.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import com.stackmobile.ca6source72396.navigation.NavRoutes


@Composable
fun DetailScreen(
    backStackEntry: NavBackStackEntry,
    onConfirm: (Int) -> Unit
) {

    val itemId = remember(backStackEntry) {
        backStackEntry.arguments?.getInt(NavRoutes.Detail.ARG_ITEM_ID) ?: -1
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Detail Screen", style = MaterialTheme.typography.headlineSmall)
        Text("Received ID: $itemId")

        Button(onClick = { onConfirm(itemId) }) {
            Text("Return ID and Go Back")
        }
    }
}


