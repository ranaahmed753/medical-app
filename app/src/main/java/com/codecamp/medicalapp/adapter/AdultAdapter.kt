package com.codecamp.medicalapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.codecamp.medicalapp.DetailsActivity
import com.codecamp.medicalapp.MainActivity
import com.codecamp.medicalapp.R
import com.codecamp.medicalapp.model.Adult
import com.codecamp.medicalapp.viewholder.AdultViewHolder

class AdultAdapter(var mAdultList : ArrayList<Adult>,var mContext : Context) : RecyclerView.Adapter<AdultViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdultViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.adults,parent,false);
        return AdultViewHolder(view);
    }

    override fun onBindViewHolder(holder: AdultViewHolder, position: Int) {
        holder.mUserDesignation.setText(mAdultList[position].designation)
        mAdultList[position].image?.let { holder.mUserImage.setImageResource(it) }
        holder.mRelativeLayout.setOnClickListener {
            holder.mRelativeLayout.startAnimation(AnimationUtils.loadAnimation(mContext,android.R.anim.fade_in))
            val intent = Intent(mContext, DetailsActivity::class.java);
            mContext.startActivity(intent);
            (mContext as MainActivity).finish()
        }
    }

    override fun getItemCount(): Int {
        return mAdultList.size
    }
}