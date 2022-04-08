package com.codecamp.medicalapp.viewholder

import android.content.Context
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codecamp.medicalapp.R
import com.codecamp.medicalapp.model.Men
import com.codecamp.medicalapp.util.fadeInAnimation
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily

class MenViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
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

    fun bind(men: Men){
        mUserImage.setImageResource(men.image)
        mUserDesignation.text = men.designation
    }

    fun onClick(widget : View, context: Context, onDoSomething : (position : Int, holder : MenViewHolder) -> Unit, position: Int, holder: MenViewHolder){
        widget.setOnClickListener {
            context.fadeInAnimation(widget)
            onDoSomething(position,holder)
        }
    }

    interface onItemClick{
        fun onNavigateToDetailsPage(position: Int, holder: MenViewHolder)
    }
}