package org.n27.nutshell

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.database.FirebaseDatabase
import dev.gitlive.firebase.database.database
import org.n27.nutshell.data.NutshellRepositoryImpl
import org.n27.nutshell.presentation.topics.TopicsViewModel
import org.n27.nutshell.presentation.topics.composables.TopicsScreen

@Composable
fun App() {
    MaterialTheme {
        TopicsScreen(TopicsViewModel())



        /*var showContent by remember { mutableStateOf(false) }

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
        }*/
    }
}
