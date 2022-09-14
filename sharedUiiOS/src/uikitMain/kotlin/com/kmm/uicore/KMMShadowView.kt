package uicore

import androidx.compose.runtime.Composable
import kotlinx.cinterop.ExportObjCClass
import platform.UIKit.UIView
import platform.CoreGraphics.CGRectMake


@ExportObjCClass
class KMMShadowView {

    /* iOS 渲染的视图 */
    private val view = TMMRenderView(CGRectMake(0.0, 0.0, 0.0, 0.0))

    internal fun setContent(content: @Composable () -> Unit) {
        view.composeLayer.setContent(content)
    }


    fun setViewFrameWith(originX: Double, originY: Double, width: Double, height: Double) {
        view.updateFrame(originX, originY, width, height);
    }

    fun viewWillAppear() {}
    fun viewDidDisappear() {}

    fun getUIView(): UIView {
        return view
    }

    fun detach() {
        view.detach()
    }
}

internal fun createShadowView(content: @Composable () -> Unit = { }): KMMShadowView {
    return KMMShadowView().apply {
        setContent(content)
    }
}