package org.n27.nutshell.domain

import kotlinx.coroutines.flow.Flow
import org.n27.nutshell.domain.topics.model.Topics

interface NutshellRepository {

    suspend fun getTopics() : Flow<Topics>
}
