package com.giaquino.kotlin.model.entity;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * @author Gian Darren Aquino
 *
 * Currently auto-value-gson wont work with kotlin
 */
@AutoValue public abstract class User {

    public static User create(String login, String avatar) {
        return new AutoValue_User(login, avatar);
    }

    public static TypeAdapter<User> typeAdapter(Gson gson) {
        return new AutoValue_User.GsonTypeAdapter(gson);
    }

    @SerializedName("login") public abstract String login();

    @SerializedName("avatar_url") public abstract String avatar();
}
