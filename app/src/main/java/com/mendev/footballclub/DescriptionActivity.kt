package com.mendev.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class DescriptionActivity: AppCompatActivity() {
    companion object {
        val keteranganID = 3
        val POSITIONEXTRA = "position_extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = intent
        val list = intent.getParcelableExtra<Club>(POSITIONEXTRA)

        DescriptionActivityUI(list).setContentView(this)

    }

    inner class DescriptionActivityUI(var list: Club) : AnkoComponent<DescriptionActivity> {
        override fun createView(ui: AnkoContext<DescriptionActivity>) = with(ui) {
            linearLayout {
                orientation = LinearLayout.VERTICAL
                lparams(matchParent, matchParent)

                imageView {
                    list.image?.let {
                        Picasso.get()
                                .load(it)
                                .into(this)
                    }
                    id = ClubItemUI.imageId
                    padding = dip(10)

                    this@linearLayout.gravity = Gravity.CENTER_HORIZONTAL
                }.lparams(dip(80), dip(80))

                textView {
                    id = ClubItemUI.nameId
                    text = list.name
                    textSize = sp(10).toFloat()
                    gravity = Gravity.CENTER_HORIZONTAL
                    padding = dip(10)
                }

                textView {
                    id = keteranganID
                    text = list.desc
                    gravity = Gravity.CENTER_HORIZONTAL
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                    padding = dip(10)
                }

            }

        }
    }
}