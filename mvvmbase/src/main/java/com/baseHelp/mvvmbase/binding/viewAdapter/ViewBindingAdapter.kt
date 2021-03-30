package com.baseHelp.mvvmbase.binding.viewAdapter

import android.graphics.Color
import android.view.View
import androidx.databinding.BindingAdapter


@BindingAdapter("backgroundColor")
fun View.backgroundColor(color: String) {
    setBackgroundColor(Color.parseColor(color))
}
