package org.n27.nutshell.presentation.topics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.n27.nutshell.data.DataSource
import org.n27.nutshell.domain.topics.model.Topic
import org.n27.nutshell.presentation.topics.entities.TopicsAction
import org.n27.nutshell.presentation.topics.entities.TopicsAction.NextButtonClicked
import org.n27.nutshell.presentation.topics.entities.TopicsAction.RetryButtonClicked
import org.n27.nutshell.presentation.topics.entities.TopicsEvent
import org.n27.nutshell.presentation.topics.entities.TopicsEvent.GoToNextScreen
import org.n27.nutshell.presentation.topics.entities.TopicsUiState
import org.n27.nutshell.presentation.topics.entities.TopicsUiState.Content
import org.n27.nutshell.presentation.topics.entities.TopicsUiState.Loading

class TopicsViewModel : ViewModel() {

    private val state = MutableStateFlow<TopicsUiState>(Loading)
    internal val uiState = state.asStateFlow()

    private val event = Channel<TopicsEvent>(capacity = 1, BufferOverflow.DROP_OLDEST)
    val viewEvent = event.receiveAsFlow()

    init { getTopics() }

    fun handleAction(action: TopicsAction) {
        when (action) {
            RetryButtonClicked -> onRetryButtonClicked()
            is NextButtonClicked -> onNextButtonClicked(action)
        }
    }

    private fun onRetryButtonClicked() {
        getTopics()
    }

    private fun onNextButtonClicked(action: NextButtonClicked) {
        event.trySend(GoToNextScreen(action.key, action.title))
    }

    private fun getTopics() {
        viewModelScope.launch {
            state.emit(Loading)

            DataSource.onTopics = { topics ->
                state.tryEmit(Content(
                    topics = persistentListOf(
                        Topic(
                            key = "taxes",
                            title = topics ?: "Lul",
                            imageUrl = "http://cdn-icons-png.flaticon.com/128/3012/3012365.png"
                        ),
                        Topic(
                            key = "gini",
                            title = "Income equality in Europe",
                            imageUrl = "http://cdn-icons-png.flaticon.com/128/149/149164.png"
                        )
                    )
                ))
            }

            DataSource.getTopics()
        }
    }
}
