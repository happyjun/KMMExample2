package business

import com.example.kmm.sharedui.MainUi
import uicore.KMMShadowView
import uicore.createShadowView

fun getUserCenterShadowView() : KMMShadowView =  createShadowView() {
    MainUi()
}