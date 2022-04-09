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
import com.codecamp.medicalapp.util.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var mConstraintLayout: ConstraintLayout
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

        mConstraintLayout = findViewById(R.id.constraintLayout)

        mNestedScrollView = findViewById(R.id.nestedScrollView);
        mNestedScrollView.isSmoothScrollingEnabled = true;

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

        hasFixedSize(mAdultRecyclerView,mDoctorRecyclerView,mChildrenRecyclerView,mWomenRecyclerView,mMenRecyclerView)

        loadDoctors()

        val doctors = arrayListOf<TextView>(mAdultText,mChildrenText,mWomenText,mMenText)
        if(doctors[0] == mAdultText){
            initAdult()
        }
        if(doctors[1] == mChildrenText){
            initChildren()
        }
        if(doctors[2] == mWomenText){
            initWomen()
        }
        if(doctors[3] == mMenText){
            initMen()
        }



    }

    private fun loadDoctors(){
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
        show(mAdultConstraintLayout)
        hide(mChildrenConstraintLayout,mWomenConstraintLayout,mMenConstraintLayout)


        for(i in 0..10){
            mAdultList.add(Adult("Heart Specialist",drawable.handsome_doctor))
        }
        mAdultRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mAdultRecyclerView.adapter = mAdultAdapter

        for(j in 0..100){
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

        activeTextColor("#42879F",mAdultText)
        activeTextBackground(drawable.item_text_back,mAdultText)

        inactiveTextColor("#D2D1D3",mChildrenText,mWomenText,mMenText)
        inactiveTextBackground(drawable.item_inactive_back,mChildrenText,mWomenText,mMenText)
    }

    private fun initAdult(){
        mAdultText.setOnClickListener {

            fadeInAnimation(mAdultText)

            activeTextColor("#42879F",mAdultText)
            activeTextBackground(drawable.item_text_back,mAdultText)

            inactiveTextColor("#D2D1D3",mChildrenText,mWomenText,mMenText)
            inactiveTextBackground(drawable.item_inactive_back,mChildrenText,mWomenText,mMenText)

            show(mAdultConstraintLayout)
            hide(mChildrenConstraintLayout,mWomenConstraintLayout,mMenConstraintLayout)

        }
    }
    private fun initChildren(){
        mChildrenText.setOnClickListener {
            fadeInAnimation(mChildrenText)

            activeTextColor("#42879F",mChildrenText)
            activeTextBackground(drawable.item_text_back,mChildrenText)

            inactiveTextColor("#D2D1D3",mAdultText,mWomenText,mMenText)
            inactiveTextBackground(drawable.item_inactive_back,mAdultText,mWomenText,mMenText)

            show(mChildrenConstraintLayout)
            hide(mAdultConstraintLayout,mWomenConstraintLayout,mMenConstraintLayout)

        }
    }
    private fun initWomen(){
        mWomenText.setOnClickListener {

            fadeInAnimation(mWomenText)

            activeTextColor("#42879F",mWomenText)
            activeTextBackground(drawable.item_text_back,mWomenText)

            inactiveTextColor("#D2D1D3",mAdultText,mChildrenText,mMenText)
            inactiveTextBackground(drawable.item_inactive_back,mAdultText,mChildrenText,mMenText)

            show(mWomenConstraintLayout)
            hide(mChildrenConstraintLayout,mAdultConstraintLayout,mMenConstraintLayout)

        }
    }
    private fun initMen(){
        mMenText.setOnClickListener {

            fadeInAnimation(mMenText)

            activeTextColor("#42879F",mMenText)
            activeTextBackground(drawable.item_text_back,mMenText)

            inactiveTextColor("#D2D1D3",mAdultText,mChildrenText,mWomenText)
            inactiveTextBackground(drawable.item_inactive_back,mAdultText,mChildrenText,mWomenText)

            show(mMenConstraintLayout)
            hide(mChildrenConstraintLayout,mWomenConstraintLayout,mAdultConstraintLayout)

        }
    }

    override fun onStart() {
        super.onStart()
        slideLeftAnimation(mConstraintLayout)
    }

}