package com.stackmobile.ca6source72396.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.stackmobile.ca6source72396.navigation.NavRoutes
import com.stackmobile.ca6source72396.utils.ResultKeys
import kotlinx.coroutines.flow.map




@Composable
fun ListScreen(
    onNavigateToDetail: (Int) -> Unit,
    currentSavedStateHandle: SavedStateHandle?
) {

    var lastResult by remember { mutableStateOf<String?>(null) }


    val observedResult by remember(currentSavedStateHandle) {
        currentSavedStateHandle
            ?.getStateFlow(ResultKeys.ITEM_RESULT_KEY, null as String?)
            // map só para reforçar tipos/transformações se quisesse
            ?.map { it }
            ?: kotlinx.coroutines.flow.flowOf(null)
    }.collectAsStateWithLifecycle(initialValue = null)


    LaunchedEffect(observedResult) {
        if (observedResult != null) {
            lastResult = observedResult
            currentSavedStateHandle?.remove<String>(ResultKeys.ITEM_RESULT_KEY)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("List Screen", style = MaterialTheme.typography.headlineSmall)


        if (lastResult != null) {
            Text("Result received: $lastResult")
        }

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(onClick = { onNavigateToDetail(101) }) {
                Text("Go to ${NavRoutes.Detail.build(101)}")
            }
            Button(onClick = { onNavigateToDetail(102) }) {
                Text("Go to ${NavRoutes.Detail.build(102)}")
            }
        }
    }
}


