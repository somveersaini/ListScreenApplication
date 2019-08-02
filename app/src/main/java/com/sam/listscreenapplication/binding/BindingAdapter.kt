package com.sam.listscreenapplication.binding

import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sam.listscreenapplication.R


object BindingAdapters {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImage(view: ImageView, imageUrl: String) {
        Glide.with(view.context)
            .load(imageUrl).apply(RequestOptions().centerCrop())
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("goneUnless", "slideUp", requireAll = false)
    fun goneUnlessWithSlideUp(view: View, visible: Boolean, slideUp: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
        if (slideUp) {
            val bottomUp = AnimationUtils.loadAnimation(view.context, R.anim.slide_in_up)
            view.startAnimation(bottomUp)
        }
    }

    @JvmStatic
    @BindingAdapter("enableRotation")
    fun enableRotation(view: ImageView, enable: Boolean) {
        if (enable) {
            val objectAnimator = ObjectAnimator.ofFloat(view, View.ROTATION, 0.0f, 360.0f)
            objectAnimator.duration = 2000
            objectAnimator.repeatCount = Animation.INFINITE
            objectAnimator.start()
        }
    }

//    @JvmStatic
//    @BindingAdapter("slideUp")
//    fun slideUp(view: View, slideUp: Boolean) {
//        if (slideUp) {
//            val bottomUp = AnimationUtils.loadAnimation(view.context, R.anim.slide_in_up)
//            view.startAnimation(bottomUp)
//        }
//    }
}