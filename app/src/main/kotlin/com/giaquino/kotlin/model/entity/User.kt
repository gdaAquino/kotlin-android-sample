package com.giaquino.kotlin.model.entity

import com.google.gson.annotations.SerializedName
import nz.bradcampbell.paperparcel.PaperParcel
import nz.bradcampbell.paperparcel.PaperParcelable

/**
 * @author Gian Darren Aquino
 */
@PaperParcel data class User(
    @SerializedName("login") val login: String,
    @SerializedName("avatar_url") val avatar: String) : PaperParcelable {
    companion object {
        @JvmField val CREATOR = PaperParcelable.Creator(User::class.java)
    }
}