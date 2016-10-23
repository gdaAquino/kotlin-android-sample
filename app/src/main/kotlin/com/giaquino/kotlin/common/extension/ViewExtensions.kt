package com.giaquino.kotlin.common.extension

import android.support.annotation.IdRes
import android.support.v7.widget.RecyclerView
import java.util.concurrent.atomic.AtomicInteger

/**
 * @author Gian Darren Aquino
 */
@Suppress("UNCHECKED_CAST", "NOTHING_TO_INLINE")
fun <T> RecyclerView.ViewHolder.findView(@IdRes id: Int): T {
    return itemView!!.findViewById(id) as T
}

val next: AtomicInteger = AtomicInteger(1)
fun generateId(): Int {
    while (true) {
        val result = next.get()
        // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
        var new = result + 1
        if (new > 0x00FFFFFF) new = 1 // Roll over to 1, not 0.
        if (next.compareAndSet(result, new)) {
            return result
        }
    }
}