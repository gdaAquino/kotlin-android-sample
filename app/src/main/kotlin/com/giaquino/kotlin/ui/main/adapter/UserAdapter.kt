package com.giaquino.kotlin.ui.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.giaquino.kotlin.model.entity.User
import com.giaquino.kotlin.ui.main.view.UserViewHolder
import com.squareup.picasso.Picasso
import java.util.*

/**
 * @author Gian Darren Aquino
 */
class UserAdapter(val picasso: Picasso) : RecyclerView.Adapter<UserViewHolder>() {

    var users: List<User> = ArrayList()

    override fun getItemCount(): Int = users.count()

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position], picasso)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder.create(parent)
    }
}