package com.giaquino.kotlin.ui.main.view

import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.giaquino.kotlin.common.extension.findView
import com.giaquino.kotlin.model.entity.User
import com.squareup.picasso.Picasso
import org.jetbrains.anko.AnkoContext

/**
 * @author Gian Darren Aquino
 */
class UserViewHolder(itemView: View?) : ViewHolder(itemView) {

    val login: TextView = findView(UserViewHolderUI.ID_LOGIN)
    val avatar: ImageView = findView(UserViewHolderUI.ID_AVATAR)

    fun bind(user: User, picasso: Picasso) {
        login.text = user.login()
        picasso.load(user.avatar()).into(avatar)
    }

    companion object {
        fun create(parent: ViewGroup): UserViewHolder {
            return UserViewHolder(
                UserViewHolderUI().createView(AnkoContext.create(parent.context, parent, false)))
        }
    }
}