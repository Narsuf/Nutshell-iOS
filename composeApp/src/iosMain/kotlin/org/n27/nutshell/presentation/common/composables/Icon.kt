package org.n27.nutshell.presentation.common.composables

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

private val IconSize = 24.dp

@Composable
fun Icon(
    url: String,
    modifier: Modifier = Modifier,
    size: Dp = IconSize,
    colorFilter: ColorFilter? = null
) {

    KamelImage(
        resource = asyncPainterResource(url),
        contentDescription = null,
        modifier = modifier.size(size),
        colorFilter = colorFilter
    )
}
