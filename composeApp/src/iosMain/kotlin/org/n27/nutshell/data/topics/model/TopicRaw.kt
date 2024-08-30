package org.n27.nutshell.data.topics.model

import kotlinx.serialization.Serializable

@Serializable
data class TopicRaw(
    val key: String,
    val title: String,
    val imageUrl: String
)
