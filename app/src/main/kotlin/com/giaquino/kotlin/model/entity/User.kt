package com.giaquino.kotlin.model.entity

import nz.bradcampbell.paperparcel.PaperParcel
import nz.bradcampbell.paperparcel.PaperParcelable

/**
 * @author Gian Darren Aquino
 */
@PaperParcel data class User(
    val login: String,
    val html_url: String,
    val avatar_url: String) : PaperParcelable {
    companion object {
        @JvmField val CREATOR = PaperParcelable.Creator(User::class.java)
    }
}