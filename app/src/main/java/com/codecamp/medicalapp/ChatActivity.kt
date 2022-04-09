package com.codecamp.medicalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.codecamp.medicalapp.util.slideLeftAnimation

class ChatActivity : AppCompatActivity() {
    private lateinit var mBackButton : ImageView;
    private lateinit var mConstraintLayout : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        mConstraintLayout = findViewById(R.id.constraintlayout)

        mBackButton = findViewById(R.id.backButton);
        mBackButton.setOnClickListener {
            mBackButton.startAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
            startActivity(Intent(this,MainActivity::class.java));
            finish();
        }
    }

    override fun onStart() {
        super.onStart()
        slideLeftAnimation(mConstraintLayout)
    }
}