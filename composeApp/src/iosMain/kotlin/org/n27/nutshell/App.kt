package org.n27.nutshell

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import org.koin.compose.KoinIsolatedContext
import org.koin.compose.koinInject
import org.koin.core.KoinApplication
import org.koin.dsl.koinApplication
import org.n27.nutshell.data.DataSource
import org.n27.nutshell.di.AppModule
import org.n27.nutshell.presentation.topics.TopicsViewModel
import org.n27.nutshell.presentation.topics.composables.TopicsScreen

lateinit var koinApp: KoinApplication

fun initKoin(ds: DataSource) {
    koinApp = koinApplication {
        modules(AppModule(ds).module)
    }
}

@Composable
fun App() {

    KoinIsolatedContext(koinApp) {
        val viewModel: TopicsViewModel = koinInject()

        MaterialTheme {
            TopicsScreen(viewModel)
        }

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
