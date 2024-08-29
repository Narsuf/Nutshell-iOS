package org.n27.nutshell.domain

import org.n27.nutshell.domain.detail.model.Detail
import org.n27.nutshell.domain.topics.model.Topics

interface NutshellRepository {

    suspend fun getTopics() : Result<Topics>
    suspend fun getDetail(key: String) : Result<Detail>
}