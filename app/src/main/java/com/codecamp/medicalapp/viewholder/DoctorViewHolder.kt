package com.codecamp.medicalapp.viewholder

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.codecamp.medicalapp.R
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily

class DoctorViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    var dortorName : TextView;
    var doctorImage : ShapeableImageView;
    var doctorDesignation : TextView;
    var callButton : ConstraintLayout;
    init {
        dortorName = itemView.findViewById(R.id.doctorName);
        doctorImage = itemView.findViewById(R.id.doctorImage);
        val roundedImage = doctorImage.shapeAppearanceModel.toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, 10f)
            .build()
        doctorImage.shapeAppearanceModel = roundedImage
        doctorDesignation = itemView.findViewById(R.id.doctorDesignation);
        callButton = itemView.findViewById(R.id.callButton);
    }
}