package com.mendev.footballclub

import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*

class ClubItemUI: AnkoComponent<ViewGroup> {

    companion object {
        val nameId = 1
        val imageId = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>)= with(ui){
        linearLayout {
            orientation = LinearLayout.HORIZONTAL
            lparams(matchParent, wrapContent)
            padding = dip(16)

            imageView{
                id = imageId
                imageResource = R.drawable.img_arsenal

            }.lparams(dip(50), dip(50))

            textView {
                id = nameId
                text = "Menda"
            }.lparams(matchParent, wrapContent){
                margin = dip(10)

            }

        }
    }

}