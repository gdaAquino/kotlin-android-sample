package com.giaquino.kotlin.model.entity

import com.google.gson.annotations.SerializedName

/**
 * @author Gian Darren Aquino
 */
data class User(
    @SerializedName("login") val login: String,
    @SerializedName("avatar_url") val avatar: String)