package org.n27.nutshell

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.n27.nutshell.presentation.common.composables.Icon
import org.n27.nutshell.presentation.topics.TopicsViewModel
import org.n27.nutshell.presentation.topics.entities.TopicsUiState.Content

@Composable
fun App() {
    MaterialTheme {
        val viewModel = TopicsViewModel()
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        var showContent by remember { mutableStateOf(false) }

        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }

            AnimatedVisibility(showContent) {
                when (val state = uiState) {
                    is Content -> {
                        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon("http://cdn-icons-png.flaticon.com/128/10677/10677442.png")
                            Text("Compose: ${state.topics[0].title}")
                        }
                    }

                    else -> Unit
                }
            }
        }
    }
}
