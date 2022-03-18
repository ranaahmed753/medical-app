package com.codecamp.medicalapp

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codecamp.medicalapp.R.drawable
import com.codecamp.medicalapp.adapter.*
import com.codecamp.medicalapp.model.*

class MainActivity : AppCompatActivity() {

    private lateinit var mNavigationDrawerIcon : ConstraintLayout;
    private lateinit var mAdultConstraintLayout : ConstraintLayout;
    private lateinit var mChildrenConstraintLayout : ConstraintLayout;
    private lateinit var mWomenConstraintLayout : ConstraintLayout;
    private lateinit var mMenConstraintLayout : ConstraintLayout;

    private lateinit var mAdultText : TextView;
    private lateinit var mChildrenText : TextView;
    private lateinit var mWomenText : TextView;
    private lateinit var mMenText : TextView;

    private lateinit var mAdultList : ArrayList<Adult>;
    private lateinit var mDoctorList : ArrayList<Doctor>;
    private lateinit var mChildrenList : ArrayList<Children>;
    private lateinit var mWomenList : ArrayList<Women>;
    private lateinit var mMenList : ArrayList<Men>;

    private lateinit var mAdultRecyclerView : RecyclerView;
    private lateinit var mDoctorRecyclerView : RecyclerView;
    private lateinit var mChildrenRecyclerView : RecyclerView;
    private lateinit var mWomenRecyclerView : RecyclerView;
    private lateinit var mMenRecyclerView : RecyclerView;

    private lateinit var mAdultAdapter : AdultAdapter
    private lateinit var mDoctorAdapter : DoctorAdapter;
    private lateinit var mChildrenAdapter : ChildrenAdapter;
    private lateinit var mWomenAdapter : WomenAdapter;
    private lateinit var mMenAdapter : MenAdapter;

    private lateinit var mNestedScrollView : NestedScrollView

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main)

        mNestedScrollView = findViewById(R.id.nestedScrollView);
        mNestedScrollView.isSmoothScrollingEnabled = true;

        mNavigationDrawerIcon = findViewById(R.id.navigationDrawerIcon);
        mAdultRecyclerView = findViewById(R.id.adultRecyclerview);
        mDoctorRecyclerView = findViewById(R.id.doctorRecyclerView);
        mChildrenRecyclerView = findViewById(R.id.childrenRecyclerview);
        mWomenRecyclerView = findViewById(R.id.womenRecyclerview);
        mMenRecyclerView = findViewById(R.id.menRecyclerview);

        mAdultText = findViewById(R.id.adultText);
        mChildrenText = findViewById(R.id.childrenText);
        mWomenText = findViewById(R.id.womenText);
        mMenText = findViewById(R.id.menText);

        mAdultConstraintLayout = findViewById(R.id.adultConstraintLayout);
        mChildrenConstraintLayout = findViewById(R.id.childrenConstraintLayout);
        mWomenConstraintLayout = findViewById(R.id.womenConstraintLayout);
        mMenConstraintLayout = findViewById(R.id.menConstraintLayout);


        mAdultRecyclerView.setHasFixedSize(true)
        mDoctorRecyclerView.setHasFixedSize(true)
        mChildrenRecyclerView.setHasFixedSize(true)
        mWomenRecyclerView.setHasFixedSize(true)
        mMenRecyclerView.setHasFixedSize(true)

        mAdultList = arrayListOf();
        mAdultAdapter = AdultAdapter(mAdultList,this);

        mDoctorList = arrayListOf();
        mDoctorAdapter = DoctorAdapter(mDoctorList,this);

        mChildrenList = arrayListOf();
        mChildrenAdapter = ChildrenAdapter(mChildrenList,this);

        mWomenList = arrayListOf();
        mWomenAdapter = WomenAdapter(mWomenList,this);

        mMenList = arrayListOf();
        mMenAdapter = MenAdapter(mMenList,this);

        mAdultConstraintLayout.visibility = View.VISIBLE
        mChildrenConstraintLayout.visibility = View.GONE
        mWomenConstraintLayout.visibility = View.GONE
        mMenConstraintLayout.visibility = View.GONE

        for(i in 0..10){
            mAdultList.add(Adult("Heart Specialist",drawable.handsome_doctor))
        }
        mAdultRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mAdultRecyclerView.adapter = mAdultAdapter

        for(j in 0..10){
            mDoctorList.add(Doctor("Iqbal Mahmud",drawable.doctor,"Orthopedic Specialist"))
        }
        mDoctorRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mDoctorRecyclerView.adapter = mDoctorAdapter

        for(k in 0..10){
            mChildrenList.add(Children("Child Specialist",drawable.men_doctor))
        }
        mChildrenRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mChildrenRecyclerView.adapter = mChildrenAdapter

        for(m in 0..10){
            mWomenList.add(Women("Gynochologist",drawable.women))
        }
        mWomenRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mWomenRecyclerView.adapter = mWomenAdapter

        for(n in 0..10){
            mMenList.add(Men("Neurologyst",drawable.men_doctorsssss))
        }
        mMenRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mMenRecyclerView.adapter = mMenAdapter

        mAdultText.setTextColor(Color.parseColor("#42879F"))
        mAdultText.setBackgroundResource(drawable.item_text_back)
        mChildrenText.setTextColor(Color.parseColor("#D2D1D3"))
        mChildrenText.setBackgroundResource(drawable.item_inactive_back)
        mWomenText.setTextColor(Color.parseColor("#D2D1D3"))
        mWomenText.setBackgroundResource(drawable.item_inactive_back)
        mMenText.setTextColor(Color.parseColor("#D2D1D3"))
        mMenText.setBackgroundResource(drawable.item_inactive_back)

        mAdultText.setOnClickListener {
            mAdultText.startAnimation(AnimationUtils.loadAnimation(applicationContext,android.R.anim.fade_in))

            mAdultText.setTextColor(Color.parseColor("#42879F"))
            mAdultText.setBackgroundResource(drawable.item_text_back)

            mChildrenText.setTextColor(Color.parseColor("#D2D1D3"))
            mChildrenText.setBackgroundResource(drawable.item_inactive_back)

            mWomenText.setTextColor(Color.parseColor("#D2D1D3"))
            mWomenText.setBackgroundResource(drawable.item_inactive_back)

            mMenText.setTextColor(Color.parseColor("#D2D1D3"))
            mMenText.setBackgroundResource(drawable.item_inactive_back)

            mAdultConstraintLayout.visibility = View.VISIBLE
            mChildrenConstraintLayout.visibility = View.GONE
            mWomenConstraintLayout.visibility = View.GONE
            mMenConstraintLayout.visibility = View.GONE
        }
        mChildrenText.setOnClickListener {
            mChildrenText.startAnimation(AnimationUtils.loadAnimation(applicationContext,android.R.anim.fade_in))
            mChildrenText.setTextColor(Color.parseColor("#42879F"))
            mChildrenText.setBackgroundResource(drawable.item_text_back)

            mAdultText.setTextColor(Color.parseColor("#D2D1D3"))
            mAdultText.setBackgroundResource(drawable.item_inactive_back)

            mWomenText.setTextColor(Color.parseColor("#D2D1D3"))
            mWomenText.setBackgroundResource(drawable.item_inactive_back)

            mMenText.setTextColor(Color.parseColor("#D2D1D3"))
            mMenText.setBackgroundResource(drawable.item_inactive_back)

            mChildrenConstraintLayout.visibility = View.VISIBLE
            mAdultConstraintLayout.visibility = View.GONE
            mWomenConstraintLayout.visibility = View.GONE
            mMenConstraintLayout.visibility = View.GONE
        }
        mWomenText.setOnClickListener {
            mWomenText.startAnimation(AnimationUtils.loadAnimation(applicationContext,android.R.anim.fade_in))
            mWomenText.setTextColor(Color.parseColor("#42879F"))
            mWomenText.setBackgroundResource(drawable.item_text_back)

            mAdultText.setTextColor(Color.parseColor("#D2D1D3"))
            mAdultText.setBackgroundResource(drawable.item_inactive_back)

            mChildrenText.setTextColor(Color.parseColor("#D2D1D3"))
            mChildrenText.setBackgroundResource(drawable.item_inactive_back)

            mMenText.setTextColor(Color.parseColor("#D2D1D3"))
            mMenText.setBackgroundResource(drawable.item_inactive_back)

            mWomenConstraintLayout.visibility = View.VISIBLE
            mChildrenConstraintLayout.visibility = View.GONE
            mAdultConstraintLayout.visibility = View.GONE
            mMenConstraintLayout.visibility = View.GONE
        }
        mMenText.setOnClickListener {
            mMenText.startAnimation(AnimationUtils.loadAnimation(applicationContext,android.R.anim.fade_in))
            mMenText.setTextColor(Color.parseColor("#42879F"))
            mMenText.setBackgroundResource(drawable.item_text_back)

            mAdultText.setTextColor(Color.parseColor("#D2D1D3"))
            mAdultText.setBackgroundResource(drawable.item_inactive_back)

            mWomenText.setTextColor(Color.parseColor("#D2D1D3"))
            mWomenText.setBackgroundResource(drawable.item_inactive_back)

            mChildrenText.setTextColor(Color.parseColor("#D2D1D3"))
            mChildrenText.setBackgroundResource(drawable.item_inactive_back)

            mMenConstraintLayout.visibility = View.VISIBLE
            mChildrenConstraintLayout.visibility = View.GONE
            mWomenConstraintLayout.visibility = View.GONE
            mAdultConstraintLayout.visibility = View.GONE
        }
    }
}