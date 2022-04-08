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
import com.codecamp.medicalapp.model.Men
import com.codecamp.medicalapp.viewholder.MenViewHolder

class MenAdapter(var mMenList : ArrayList<Men>, var mContext : Context) : RecyclerView.Adapter<MenViewHolder>(),MenViewHolder.onItemClick {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.men,parent,false);
        return MenViewHolder(view);
    }

    override fun onBindViewHolder(holder: MenViewHolder, position: Int) {
        holder.bind(mMenList[position])
        holder.onClick(holder.mRelativeLayout,mContext,::onNavigateToDetailsPage,position,holder)
    }

    override fun getItemCount(): Int {
        return mMenList.size;
    }

    override fun onNavigateToDetailsPage(position: Int, holder: MenViewHolder) {
        val intent = Intent(mContext,DetailsActivity::class.java)
        mContext.startActivity(intent)
        (mContext as MainActivity).finish()
    }
}