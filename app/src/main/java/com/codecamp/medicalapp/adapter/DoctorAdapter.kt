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

class DoctorAdapter(var doctorList : ArrayList<Doctor>,var mContext : Context) : RecyclerView.Adapter<DoctorViewHolder>(),DoctorViewHolder.onItemClick {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.doctors,parent,false);
        return DoctorViewHolder(view);
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        holder.bind(doctorList[position])
        holder.onClick(holder.doctorConstraintLayout,mContext,::onNavigateToDetailsPage,position,holder)
        holder.onClick(holder.callButton,mContext,::onNavigateToCall,position,holder)
    }

    override fun getItemCount(): Int {
       return doctorList.size;
    }

    override fun onNavigateToCall(position: Int, holder: DoctorViewHolder) {
        val intent = Intent(mContext,ChatActivity::class.java)
        mContext.startActivity(intent)
        (mContext as MainActivity).finish()
    }

    override fun onNavigateToDetailsPage(position: Int, holder: DoctorViewHolder) {
        val intent = Intent(mContext,DetailsActivity::class.java)
        mContext.startActivity(intent)
        (mContext as MainActivity).finish()
    }
}