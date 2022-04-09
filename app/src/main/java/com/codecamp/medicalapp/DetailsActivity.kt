package com.codecamp.medicalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.codecamp.medicalapp.util.fadeInAnimation
import com.codecamp.medicalapp.util.navigate
import com.codecamp.medicalapp.util.slideLeftAnimation
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily

class DetailsActivity : AppCompatActivity() {
    private lateinit var mEmailButton : ConstraintLayout;
    private lateinit var mCallButton : ConstraintLayout;
    private lateinit var mVideocamButton : ConstraintLayout;
    private lateinit var mDoctorImage : ShapeableImageView;
    private lateinit var mBackButton : ConstraintLayout;
    private lateinit var mConstraintLayout: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        mConstraintLayout = findViewById(R.id.constraintLayout)

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
            fadeInAnimation(mBackButton)
            navigate(this,MainActivity(),::finish)
        }
        mEmailButton.setOnClickListener {
            fadeInAnimation(mEmailButton)
            navigate(this,CallActivity(),::finish)
        }

        mCallButton.setOnClickListener {
            fadeInAnimation(mCallButton)
            navigate(this,CallActivity(),::finish)
        }

        mVideocamButton.setOnClickListener {
            fadeInAnimation(mVideocamButton)
            navigate(this,CallActivity(),::finish)
        }
    }

    override fun onStart() {
        super.onStart()
        slideLeftAnimation(mConstraintLayout)
    }
}