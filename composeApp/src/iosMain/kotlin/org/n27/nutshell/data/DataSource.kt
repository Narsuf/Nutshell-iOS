package org.n27.nutshell.data

object DataSource {

    lateinit var onTopics: (String?) -> Unit

    fun getTopics() = getTopics.invoke()
}
