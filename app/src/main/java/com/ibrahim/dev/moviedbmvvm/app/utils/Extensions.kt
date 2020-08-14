package com.ibrahim.dev.moviedbmvvm.app.utils

import android.opengl.Visibility
import android.view.View

fun View.show(isVisibility: Boolean) {
    if (isVisibility) {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.GONE
    }
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

