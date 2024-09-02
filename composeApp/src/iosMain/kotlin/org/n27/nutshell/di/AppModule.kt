package org.n27.nutshell.di

import org.koin.dsl.module
import org.n27.nutshell.data.DataSource
import org.n27.nutshell.data.NutshellRepositoryImpl
import org.n27.nutshell.presentation.topics.TopicsViewModel

class AppModule(private val ds: DataSource) {
    val module = module {
        single { NutshellRepositoryImpl(ds) }
        factory { TopicsViewModel(get()) }
    }
}
