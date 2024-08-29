package org.n27.nutshell.presentation.common.mapping

import org.n27.nutshell.Constants.NO_INTERNET_CONNECTION
import org.n27.nutshell.presentation.common.model.Error as MyError

fun Throwable.toError() = message?.let {
    when (it) {
        NO_INTERNET_CONNECTION -> MyError(
            title = "You are offline",
            description = "Please check your internet connection and try again"
        )

        else -> MyError()
    }
} ?: MyError()
