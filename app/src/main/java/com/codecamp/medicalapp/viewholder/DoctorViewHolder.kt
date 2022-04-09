package com.codecamp.medicalapp.viewholder

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.codecamp.medicalapp.R
import com.codecamp.medicalapp.model.Doctor
import com.codecamp.medicalapp.util.fadeInAnimation
import com.codecamp.medicalapp.util.slideLeftAnimation
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily

class DoctorViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    var dortorName : TextView;
    var doctorImage : ShapeableImageView;
    var doctorDesignation : TextView;
    var callButton : ConstraintLayout;
    var doctorConstraintLayout : ConstraintLayout
    init {
        dortorName = itemView.findViewById(R.id.doctorName);
        doctorImage = itemView.findViewById(R.id.doctorImage);
        val roundedImage = doctorImage.shapeAppearanceModel.toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, 10f)
            .build()
        doctorImage.shapeAppearanceModel = roundedImage
        doctorDesignation = itemView.findViewById(R.id.doctorDesignation);
        callButton = itemView.findViewById(R.id.callButton);
        doctorConstraintLayout = itemView.findViewById(R.id.doctorConstraintLayout)
    }

    fun bind(doctor : Doctor){
        dortorName.text = doctor.doctorName
        doctorImage.setImageResource(doctor.doctorImage)
        doctorDesignation.text = doctor.doctorDesignation
    }

    fun onClick(widget : View, context: Context, onDoSomething : (position : Int, holder : DoctorViewHolder) -> Unit,position: Int,holder: DoctorViewHolder){
        widget.setOnClickListener {
            context.fadeInAnimation(widget)
            onDoSomething(position,holder)

        }
    }

    fun fadeInEffect(widget: View, context: Context){
        context.fadeInAnimation(widget)
    }

    interface onItemClick{
        fun onNavigateToCall(position : Int, holder : DoctorViewHolder)
        fun onNavigateToDetailsPage(position: Int, holder: DoctorViewHolder)
    }
}