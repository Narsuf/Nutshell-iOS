package org.n27.nutshell.data.topics.model

import kotlinx.serialization.Serializable

@Serializable
data class TopicsRaw(
    val items: List<TopicRaw>
)
