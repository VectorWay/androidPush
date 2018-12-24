package com.github.vectorway.vectorway.utils

import android.view.View
import androidx.core.content.ContextCompat

fun Int.getString() = VectorApplication.getContext().getString(this)

fun Int.getDrawable() = VectorApplication.getContext().getDrawable(this)

fun Int.getColor() = ContextCompat.getColor(VectorApplication.getContext(), this)

fun View.showIf(condition: Boolean, invisible: Boolean = false) {
    if(condition && invisible) {
        this.visibility = View.INVISIBLE
    }
    else if(condition) {
        this.visibility = View.GONE
    }
    else {
        this.visibility = View.VISIBLE
    }
}