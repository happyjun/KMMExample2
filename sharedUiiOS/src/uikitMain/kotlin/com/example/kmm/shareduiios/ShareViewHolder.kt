package com.example.kmm.shareduiios

import androidx.compose.ui.window.Application
import com.example.kmm.sharedui.MainUi
import kotlinx.cinterop.ExportObjCClass
import platform.UIKit.UIView

@ExportObjCClass
class ShareViewHolder {

    val content: UIView = Application {
        MainUi()
    }.view

}