package com.codecamp.medicalapp.viewholder

import android.content.Context
import android.view.TextureView
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codecamp.medicalapp.R
import com.codecamp.medicalapp.model.Adult
import com.codecamp.medicalapp.util.fadeInAnimation
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily

class AdultViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    var mUserImage : ShapeableImageView;
    var mUserDesignation : TextView;
    var mRelativeLayout : RelativeLayout;
    init {
        mUserImage = itemView.findViewById(R.id.userImage);
        val roundedImage = mUserImage.shapeAppearanceModel.toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, 15f)
            .build()
        mUserImage.shapeAppearanceModel = roundedImage
        mUserDesignation = itemView.findViewById(R.id.designation);
        mRelativeLayout = itemView.findViewById(R.id.relativeLayout);
    }

    fun bind(adult : Adult){
        mUserImage.setImageResource(adult.image)
        mUserDesignation.text = adult.designation
    }

    fun onClick(widget : View, context: Context, onDoSomething : (position : Int, holder : AdultViewHolder) -> Unit, position: Int, holder: AdultViewHolder){
        widget.setOnClickListener {
            context.fadeInAnimation(widget)
            onDoSomething(position,holder)
        }
    }

    interface onItemClick{
        fun onNavigateToDetailsPage(position: Int, holder: AdultViewHolder)
    }
}