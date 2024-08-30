package org.n27.nutshell.data.topics.mapping

import cocoapods.FirebaseDatabase.FIRDataSnapshot
import dev.gitlive.firebase.database.ChildEvent
import dev.gitlive.firebase.database.DataSnapshot
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.serialization.json.Json
import org.n27.nutshell.data.topics.model.TopicRaw
import org.n27.nutshell.data.topics.model.TopicsRaw
import org.n27.nutshell.domain.topics.model.Topic
import org.n27.nutshell.domain.topics.model.Topics

fun String.toTopics(): Topics = Json
    .decodeFromString(TopicsRaw.serializer(), this)
    .toTopics()

internal fun TopicsRaw.toTopics() = Topics(
    items = items.map { it.toTopic() }
)

private fun TopicRaw.toTopic() = Topic(
    key = key,
    title = title,
    imageUrl = imageUrl
)
