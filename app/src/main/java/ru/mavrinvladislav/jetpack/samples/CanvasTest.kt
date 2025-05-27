package ru.mavrinvladislav.jetpack.samples

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun CanvasTest() {

    val points = remember {
        mutableStateListOf<Point>()
    }

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .pointerInput(key1 = Unit) {
                detectDragGestures(
                    onDragStart = {
                        points += Point(it, true)
                    },
                    onDrag = { change, _ ->
                        points += change.historical.map { Point(it.position, false) }
                    }
                )
            }
    ) {
        val path = Path()
        points.forEach { point ->
            if (point.isStartedPosition) {
                path.moveTo(
                    point.offset.x,
                    point.offset.y
                )
            } else {
                path.lineTo(
                    point.offset.x,
                    point.offset.y
                )
            }
        }
        drawPath(
            brush = Brush.linearGradient(colors = listOf(Color.Cyan, Color.Magenta)),
            path = path,
            style = Stroke(10.dp.toPx())
        )
    }
}

data class Point(
    val offset: Offset,
    val isStartedPosition: Boolean
)

@Composable
fun Dp.toPx() = with(LocalDensity.current) {
    this@toPx.toPx()
}