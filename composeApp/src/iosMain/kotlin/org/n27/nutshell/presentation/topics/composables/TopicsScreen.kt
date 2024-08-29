package org.n27.nutshell.presentation.topics.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.n27.nutshell.presentation.common.composables.screen.Screen
import org.n27.nutshell.presentation.common.constants.Spacing
import org.n27.nutshell.presentation.topics.entities.TopicsAction
import org.n27.nutshell.presentation.topics.entities.TopicsUiState
import org.n27.nutshell.presentation.topics.entities.TopicsUiState.Content

internal const val TEST_TAG_TOPICS_LOADING_VIEW = "topics_loading.view"

@Composable
fun TopicsScreen(uiState: TopicsUiState, onAction: (action: TopicsAction) -> Unit) {

    Screen(
        title = "Topics",
        modifier = Modifier.padding(top = Spacing.tight)
    ) {
        when (uiState) {
            is Content -> TopicsContent(uiState, onAction)
            else -> Unit
        }
    }
}
