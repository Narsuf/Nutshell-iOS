package org.n27.nutshell.presentation.topics.entities

sealed class TopicsAction {

    data object RetryButtonClicked : TopicsAction()
    data class NextButtonClicked(val key: String, val title: String) : TopicsAction()
}