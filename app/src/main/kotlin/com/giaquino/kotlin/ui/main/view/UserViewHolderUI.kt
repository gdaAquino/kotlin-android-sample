package com.giaquino.kotlin.ui.main.view

import android.support.annotation.IdRes
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import com.giaquino.kotlin.common.extension.generateId
import org.jetbrains.anko.*

/**
 * @author Gian Darren Aquino
 */
class UserViewHolderUI : AnkoComponent<ViewGroup> {

    companion object {
        @IdRes val ID_LOGIN: Int = generateId()
        @IdRes val ID_AVATAR: Int = generateId()
    }

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        linearLayout {
            orientation = LinearLayout.HORIZONTAL
            lparams {
                width = matchParent
                height = wrapContent
                padding = dip(16)
            }
            imageView {
                id = ID_AVATAR
                lparams {
                    width = dip(50)
                    height = dip(50)
                    rightMargin = dip(16)
                }
            }
            textView {
                id = ID_LOGIN
                textSize = 16F
                lparams {
                    gravity = Gravity.CENTER_VERTICAL
                }
            }
        }
    }
}
