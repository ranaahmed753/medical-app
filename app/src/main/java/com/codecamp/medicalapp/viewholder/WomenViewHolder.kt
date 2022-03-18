package com.codecamp.medicalapp.viewholder

import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codecamp.medicalapp.R
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily

class WomenViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
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
}