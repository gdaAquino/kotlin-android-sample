package com.giaquino.kotlin.model.api.adapter

import com.google.gson.TypeAdapterFactory
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory

/**
 * @author Gian Darren Aquino
 */

@GsonTypeAdapterFactory abstract class EntityAdapterFactory : TypeAdapterFactory {

    companion object {
        fun create(): TypeAdapterFactory {
            return AutoValueGson_EntityAdapterFactory()
        }
    }
}
