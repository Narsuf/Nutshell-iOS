package org.n27.nutshell.di

import org.koin.dsl.module
import org.n27.nutshell.data.NutshellRepositoryImpl
import org.n27.nutshell.presentation.topics.TopicsViewModel

class AppModule {
    val module = module {
        single { NutshellRepositoryImpl() }
        factory { TopicsViewModel(get()) }
    }
}
