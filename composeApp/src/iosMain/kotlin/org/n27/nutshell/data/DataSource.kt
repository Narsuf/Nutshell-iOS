package org.n27.nutshell.data

interface DataSource {

    fun getTopics(onTopics: (String?) -> Unit)
}
