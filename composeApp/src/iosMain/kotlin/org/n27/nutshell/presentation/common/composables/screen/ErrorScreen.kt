package org.n27.nutshell.presentation.common.composables.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import org.n27.nutshell.presentation.common.composables.Button
import org.n27.nutshell.presentation.common.constants.Palette
import org.n27.nutshell.presentation.common.constants.Spacing
import org.n27.nutshell.presentation.common.constants.Typography
import org.n27.nutshell.presentation.common.model.Error

private val AnimationSize = 80.dp

internal const val TEST_TAG_ERROR_VIEW = "error.view"
internal const val TEST_TAG_ERROR_TITLE = "error.title"
internal const val TEST_TAG_ERROR_DESCRIPTION = "error.description"

@Composable
fun ErrorScreen(error: Error, onButtonClick: () -> Unit) {

    Text(
        text = error.title,
        modifier = Modifier
            .testTag(TEST_TAG_ERROR_TITLE)
            .padding(bottom = Spacing.default),
        style = Typography.SmallTitle
    )

    Text(
        text = error.description,
        modifier = Modifier
            .testTag(TEST_TAG_ERROR_DESCRIPTION)
            .padding(bottom = Spacing.tight),
        color = Palette.Gray600
    )

    Button(
        onClick = onButtonClick,
        text = "Retry",
    )
}
