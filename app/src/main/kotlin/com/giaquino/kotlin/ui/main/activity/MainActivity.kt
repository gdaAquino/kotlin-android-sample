package com.giaquino.kotlin.ui.main.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.giaquino.kotlin.KotlinApplication
import com.giaquino.kotlin.model.api.GithubApi
import com.giaquino.kotlin.ui.main.adapter.UserAdapter
import com.squareup.picasso.Picasso
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var api: GithubApi
    @Inject lateinit var picasso: Picasso

    val adapter: UserAdapter by lazy {
        UserAdapter(picasso)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        KotlinApplication.graph.inject(this)
        MainActivityUI().setContentView(this)
        initialize()
    }

    private fun initialize() {
        api.getContributors("square", "retrofit")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ users ->
                adapter.users = users
                adapter.notifyDataSetChanged()
            }, { error ->
                toast(error.message.toString())
            })
    }
}
