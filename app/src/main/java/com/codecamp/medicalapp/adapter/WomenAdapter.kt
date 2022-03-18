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
import com.codecamp.medicalapp.model.Children
import com.codecamp.medicalapp.model.Women
import com.codecamp.medicalapp.viewholder.WomenViewHolder

class WomenAdapter(var mWomenList : ArrayList<Women>, var mContext : Context) : RecyclerView.Adapter<WomenViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WomenViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.women,parent,false);
        return WomenViewHolder(view);
    }

    override fun onBindViewHolder(holder: WomenViewHolder, position: Int) {
        holder.mUserDesignation.setText(mWomenList[position].designation);
        mWomenList[position].image?.let { holder.mUserImage.setImageResource(it) }
        holder.mRelativeLayout.setOnClickListener {
            holder.mRelativeLayout.startAnimation(AnimationUtils.loadAnimation(mContext,android.R.anim.fade_in))
            val intent = Intent(mContext, DetailsActivity::class.java);
            mContext.startActivity(intent);
            (mContext as MainActivity).finish()
        }
    }

    override fun getItemCount(): Int {
       return mWomenList.size;
    }
}