package com.codecamp.medicalapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.codecamp.medicalapp.ChatActivity
import com.codecamp.medicalapp.DetailsActivity
import com.codecamp.medicalapp.MainActivity
import com.codecamp.medicalapp.R
import com.codecamp.medicalapp.model.Doctor
import com.codecamp.medicalapp.viewholder.DoctorViewHolder

class DoctorAdapter(var doctorList : ArrayList<Doctor>,var mContext : Context) : RecyclerView.Adapter<DoctorViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.doctors,parent,false);
        return DoctorViewHolder(view);
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        holder.dortorName.setText(doctorList[position].doctorName)
        doctorList[position].doctorImage?.let { holder.doctorImage.setImageResource(it) }
        holder.doctorDesignation.setText(doctorList[position].doctorDesignation)
        holder.callButton.setOnClickListener {
            holder.callButton.startAnimation(AnimationUtils.loadAnimation(mContext,android.R.anim.fade_in))
            val intent = Intent(mContext,ChatActivity::class.java);
            mContext.startActivity(intent);
            (mContext as MainActivity).finish()
        }
    }

    override fun getItemCount(): Int {
       return doctorList.size;
    }
}