package com.codecamp.medicalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily

class CallActivity : AppCompatActivity() {
    private lateinit var mUserImage : ShapeableImageView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call)
        mUserImage = findViewById(R.id.userImage);
        val roundedImage = mUserImage.shapeAppearanceModel.toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, 10f)
            .build()
        mUserImage.shapeAppearanceModel = roundedImage
    }
}