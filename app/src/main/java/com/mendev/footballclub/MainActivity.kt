package com.mendev.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView


class MainActivity : AppCompatActivity() {

    var clubItem : MutableList<Club> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataClub()

        verticalLayout {
            lparams(matchParent, matchParent)
            orientation = LinearLayout.VERTICAL

            recyclerView {
                lparams(matchParent, matchParent)
                layoutManager = LinearLayoutManager(context)
                adapter = ClubAdapter(clubItem) {
                    startActivity(intentFor<DescriptionActivity>(DescriptionActivity.POSITIONEXTRA to it).singleTop())
                    toast(it.name.toString())

                }
            }
        }

    }

    private fun dataClub() {
        val nameClub = resources.getStringArray(R.array.club_name)
        val imgClub = resources.obtainTypedArray(R.array.club_image)
        val descClub = resources.getStringArray(R.array.club_desc)

        clubItem.clear()

        for (i in nameClub.indices){
            clubItem.add(Club(nameClub[i], imgClub.getResourceId(i,0), descClub[i] ))
        }

        imgClub.recycle()
    }
}
