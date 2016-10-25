package com.giaquino.kotlin.ui.main.activity

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearLayoutManager.VERTICAL
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.verticalLayout

/**
 * @author Gian Darren Aquino
 */
class MainActivityUI : AnkoComponent<MainActivity> {

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            val toolbar = toolbar {
                lparams {
                    width = matchParent
                }
            }
            owner.setSupportActionBar(toolbar)
            recyclerView {
                layoutManager = LinearLayoutManager(owner, VERTICAL, false)
                adapter = owner.adapter
                lparams {
                    width = matchParent
                    height = matchParent
                }
            }
        }
    }
}


