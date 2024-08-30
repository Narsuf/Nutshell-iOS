package org.n27.nutshell.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import org.n27.nutshell.data.topics.mapping.toTopics
import org.n27.nutshell.domain.NutshellRepository
import org.n27.nutshell.domain.topics.model.Topics

class NutshellRepositoryImpl : NutshellRepository {

    override suspend fun getTopics(): Flow<Topics> = channelFlow {
        DataSource.onTopics = { json ->
            json?.toTopics()?.let { trySend(it) }
        }

        DataSource.getTopics()
    }
}
