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
import com.codecamp.medicalapp.viewholder.ChildrenViewHolder

class ChildrenAdapter(var mChildrenList : ArrayList<Children>,var mContext : Context) : RecyclerView.Adapter<ChildrenViewHolder>(),ChildrenViewHolder.onItemClick
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildrenViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.children,parent,false)
        return ChildrenViewHolder(view);
    }

    override fun onBindViewHolder(holder: ChildrenViewHolder, position: Int) {
        holder.bind(mChildrenList[position])
        holder.onClick(holder.mRelativeLayout,mContext,::onNavigateToDetailsPage,position,holder)
    }

    override fun getItemCount(): Int {
        return mChildrenList.size
    }

    override fun onNavigateToDetailsPage(position: Int, holder: ChildrenViewHolder) {
        val intent = Intent(mContext,DetailsActivity::class.java)
        mContext.startActivity(intent)
        (mContext as MainActivity).finish()
    }
}