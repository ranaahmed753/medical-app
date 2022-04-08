package com.codecamp.medicalapp.util

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

fun Context.fadeInAnimation(widget: View){
    widget.startAnimation(AnimationUtils.loadAnimation(applicationContext,android.R.anim.fade_in))
}
fun hide(widget1 : View, widget2: View, widget3: View){
    widget1.visibility = View.GONE
    widget2.visibility = View.GONE
    widget3.visibility = View.GONE
}

fun show(widget : View){
   widget.visibility = View.VISIBLE
}

fun textColor(color : String,widget: TextView){
    widget.setTextColor(Color.parseColor(color))
}
fun backgroundColor(color : Int,widget: TextView){
    widget.setBackgroundResource(color)
}

fun activeTextColor(color : String,widget: TextView){
    widget.setTextColor(Color.parseColor(color))
}

fun activeTextBackground(color : Int,widget: TextView){
    widget.setBackgroundResource(color)
}

fun inactiveTextColor(color : String,widget1: TextView, widget2: TextView ,widget3: TextView){
    widget1.setTextColor(Color.parseColor(color))
    widget2.setTextColor(Color.parseColor(color))
    widget3.setTextColor(Color.parseColor(color))
}

fun inactiveTextBackground(color: Int, widget1: TextView, widget2: TextView, widget3: TextView){
    widget1.setBackgroundResource(color)
    widget2.setBackgroundResource(color)
    widget3.setBackgroundResource(color)
}

fun hasFixedSize(widget1: RecyclerView ,widget2: RecyclerView ,widget3: RecyclerView ,widget4: RecyclerView, widget5: RecyclerView){
    widget1.setHasFixedSize(true)
    widget2.setHasFixedSize(true)
    widget3.setHasFixedSize(true)
    widget4.setHasFixedSize(true)
    widget5.setHasFixedSize(true)
}