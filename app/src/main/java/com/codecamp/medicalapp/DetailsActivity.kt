package com.codecamp.medicalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily

class DetailsActivity : AppCompatActivity() {
    private lateinit var mEmailButton : ConstraintLayout;
    private lateinit var mCallButton : ConstraintLayout;
    private lateinit var mVideocamButton : ConstraintLayout;
    private lateinit var mDoctorImage : ShapeableImageView;
    private lateinit var mBackButton : ConstraintLayout;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        mDoctorImage = findViewById(R.id.doctorImage);
        val roundedImage = mDoctorImage.shapeAppearanceModel.toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, 10f)
            .build()
        mDoctorImage.shapeAppearanceModel = roundedImage
        mBackButton = findViewById(R.id.backButton);
        mEmailButton = findViewById(R.id.emailLayout);
        mCallButton = findViewById(R.id.callLayout);
        mVideocamButton = findViewById(R.id.videoLayout);
        mBackButton.setOnClickListener {
            mBackButton.startAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
            startActivity(Intent(this,MainActivity::class.java));
            finish();
        }
        mEmailButton.setOnClickListener {
            mEmailButton.startAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));

        }
        mCallButton.setOnClickListener {
            mCallButton.startAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
            startActivity(Intent(applicationContext,CallActivity::class.java));
            finish();

        }
        mVideocamButton.setOnClickListener {
            mVideocamButton.startAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));

        }
    }
}