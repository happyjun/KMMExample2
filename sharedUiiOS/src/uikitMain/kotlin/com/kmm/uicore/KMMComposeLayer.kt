package uicore

import androidx.compose.runtime.Composable
import androidx.compose.ui.ComposeScene
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.PointerType
import androidx.compose.ui.input.pointer.toCompose
import androidx.compose.ui.unit.Constraints
import org.jetbrains.skia.Canvas
import kotlinx.coroutines.Dispatchers
import org.jetbrains.skiko.*
import platform.UIKit.UIView

class TMMComposeLayer(private val view: UIView, private val getTopLeftOffset: () -> Offset) {
    private var isDisposed = false

    val skiaLayer: SkiaLayer = SkiaLayer().apply {
        // 这一步较关键
        attachTo(view)
        skikoView = LayerView()
    }

    private val scene = ComposeScene(
        coroutineContext = Dispatchers.Main,
        invalidate = skiaLayer::needRedraw
    )

    fun dispose() {
        skiaLayer.detach()
        scene.close()
        isDisposed = true
    }

    internal fun setContent(content: @Composable () -> Unit) {
        scene.setContent(content = content)
    }

    fun setSize(width: Int, height: Int) {
        scene.constraints = Constraints(maxWidth = width, maxHeight = height);
    }

    inner class LayerView : SkikoView {
        override fun onRender(canvas: Canvas, width: Int, height: Int, nanoTime: Long) {
            val contentScale = skiaLayer.contentScale
            canvas.scale(contentScale, contentScale)
            scene.render(canvas/*, (width / contentScale).toInt(), (height / contentScale).toInt()*/, nanoTime)
        }

        @OptIn(ExperimentalComposeUiApi::class)
        override fun onTouchEvent(events: Array<SkikoTouchEvent>) {
            val event = events.first()
            when (event.kind) {
                SkikoTouchEventKind.STARTED,
                SkikoTouchEventKind.MOVED,
                SkikoTouchEventKind.ENDED -> {
                    scene.sendPointerEvent(
                        eventType = event.kind.toCompose(),
                        // TODO: account for the proper density.
                        position = Offset(event.x.toFloat(), event.y.toFloat()) - getTopLeftOffset(), // * density,
                        type = PointerType.Touch,
                        nativeEvent = event
                    )
                }
                else -> {}
            }
        }

        @OptIn(ExperimentalComposeUiApi::class)
        override fun onPointerEvent(event: SkikoPointerEvent) {
            scene.sendPointerEvent(
                eventType = event.kind.toCompose(),
                // TODO: account for the proper density.
                position = Offset(event.x.toFloat(), event.y.toFloat()) - getTopLeftOffset(), // * density,
                type = PointerType.Mouse,
                nativeEvent = event
            )
        }
    }
}