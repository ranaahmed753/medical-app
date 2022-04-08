package com.codecamp.medicalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.codecamp.medicalapp.util.fadeInAnimation
import com.codecamp.medicalapp.util.navigate
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily

class CallActivity : AppCompatActivity() {

    private lateinit var mUserImage : ShapeableImageView;
    private lateinit var mCallButton : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call)

        mCallButton = findViewById(R.id.callButton)

        mUserImage = findViewById(R.id.userImage);
        val roundedImage = mUserImage.shapeAppearanceModel.toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, 10f)
            .build()
        mUserImage.shapeAppearanceModel = roundedImage

        mCallButton.setOnClickListener {
            fadeInAnimation(mCallButton)
            navigate(this,DetailsActivity(),::finish)
        }
    }
}