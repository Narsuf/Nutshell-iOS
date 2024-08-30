package org.n27.nutshell.presentation.topics.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.n27.nutshell.presentation.common.composables.screen.Screen
import org.n27.nutshell.presentation.common.constants.Spacing
import org.n27.nutshell.presentation.topics.TopicsViewModel
import org.n27.nutshell.presentation.topics.entities.TopicsUiState
import org.n27.nutshell.presentation.topics.entities.TopicsUiState.Content
import org.n27.nutshell.presentation.topics.entities.TopicsUiState.Error

internal const val TEST_TAG_TOPICS_LOADING_VIEW = "topics_loading.view"

@Composable
fun TopicsScreen(viewModel: TopicsViewModel) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Screen(
        title = "Topics",
        modifier = Modifier.padding(top = Spacing.tight)
    ) {
        when (val state = uiState) {
            is Content -> TopicsContent(state, viewModel::handleAction)
            is Error -> Text("Error")
            else -> Unit
        }
    }
}
