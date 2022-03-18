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

class ChildrenAdapter(var mChildrenList : ArrayList<Children>,var mContext : Context) : RecyclerView.Adapter<ChildrenViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildrenViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.children,parent,false)
        return ChildrenViewHolder(view);
    }

    override fun onBindViewHolder(holder: ChildrenViewHolder, position: Int) {
        holder.mUserDesignation.setText(mChildrenList[position].designation);
        mChildrenList[position].image?.let { holder.mUserImage.setImageResource(it) }
        holder.mRelativeLayout.setOnClickListener {
            holder.mRelativeLayout.startAnimation(AnimationUtils.loadAnimation(mContext,android.R.anim.fade_in))
            val intent = Intent(mContext, DetailsActivity::class.java);
            mContext.startActivity(intent);
            (mContext as MainActivity).finish()
        }
    }

    override fun getItemCount(): Int {
        return mChildrenList.size
    }
}