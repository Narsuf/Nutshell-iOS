package org.n27.nutshell.data

import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import org.n27.nutshell.data.topics.mapping.toTopics
import org.n27.nutshell.domain.NutshellRepository
import org.n27.nutshell.domain.topics.model.Topics

class NutshellRepositoryImpl(private val ds: DataSource) : NutshellRepository {

    override suspend fun getTopics(): Flow<Topics> = channelFlow {
        ds.getTopics { json ->
            var value = Topics(persistentListOf())

            json
                ?.toTopics()
                ?.let { value = it }

            trySend(value)
            close()
        }

        awaitClose()
    }
}
