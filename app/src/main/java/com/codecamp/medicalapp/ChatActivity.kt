package com.codecamp.medicalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.codecamp.medicalapp.util.fadeInAnimation
import com.codecamp.medicalapp.util.navigate
import com.codecamp.medicalapp.util.slideLeftAnimation
import de.hdodenhof.circleimageview.CircleImageView

class ChatActivity : AppCompatActivity() {
    private lateinit var mBackButton : ImageView;
    private lateinit var mConstraintLayout : ConstraintLayout
    private lateinit var doctorImage : CircleImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        mConstraintLayout = findViewById(R.id.constraintlayout)
        doctorImage = findViewById(R.id.doctorImage)

        mBackButton = findViewById(R.id.backButton);

        mBackButton.setOnClickListener {
            fadeInAnimation(mBackButton)
            navigate(this,MainActivity(),::finish)
        }

        doctorImage.setOnClickListener {
            fadeInAnimation(doctorImage)
            navigate(this,DetailsActivity(),::finish)
        }
    }

    override fun onStart() {
        super.onStart()
        slideLeftAnimation(mConstraintLayout)
    }
}