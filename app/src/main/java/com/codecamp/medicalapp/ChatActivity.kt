package com.codecamp.medicalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView

class ChatActivity : AppCompatActivity() {
    private lateinit var mBackButton : ImageView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        mBackButton = findViewById(R.id.backButton);
        mBackButton.setOnClickListener {
            mBackButton.startAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
            startActivity(Intent(this,MainActivity::class.java));
            finish();
        }
    }
}