package org.n27.nutshell.data

lateinit var getTopics: () -> Unit

val onTopics: (String?) -> Unit = {
    DataSource.onTopics(it)
}
