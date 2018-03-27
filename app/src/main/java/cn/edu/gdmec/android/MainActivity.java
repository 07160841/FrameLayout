package cn.edu.gdmec.android;


import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private FrameLayout mBodyLayout;
    public LinearLayout mBottomLayout;
    private View mCourseBtn;
    private View mExerciseBtn;
    private View mMyInfoBtn;
    private TextView tv_course;
    private TextView tv_exercises;
    private TextView tv_myInfo;
    private ImageView iv_course;
    private ImageView iv_exercises;
    private ImageView iv_myInfo;
    private view1 vi1;
    private view2 vi2;
    private view3 vi3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
        initBottomBar();
        setListener();
        setInitStatus();

    }
    private void init(){

        initBodyLayout();

    }
    private void initBottomBar(){
        mBottomLayout= (LinearLayout) findViewById(R.id.main_bottom_bar);
        mCourseBtn=findViewById(R.id.bottom_bar_course_btn);
        mExerciseBtn=findViewById(R.id.bottom_bar_exercises_btn);
        mMyInfoBtn=findViewById(R.id.bottom_bar_myinfo_btn);
        tv_course= (TextView) findViewById(R.id.bottom_bar_text_course);
        tv_exercises= (TextView) findViewById(R.id.bottom_bar_text_exercises);
        tv_myInfo= (TextView) findViewById(R.id.bottom_bar_text_myinfo);
        iv_course= (ImageView) findViewById(R.id.bottom_bar_image_course);
        iv_exercises= (ImageView) findViewById(R.id.bottom_bar_image_exercises);
        iv_myInfo= (ImageView) findViewById(R.id.bottom_bar_image_myinfo);

    }

    private void initBodyLayout(){
        mBodyLayout= (FrameLayout) findViewById(R.id.main_body);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bottom_bar_course_btn:
                clearBottomImageState();
                selectDisplayView(0);
                break;
            case R.id.bottom_bar_exercises_btn:
                clearBottomImageState();
                selectDisplayView(1);
                break;
            case R.id.bottom_bar_myinfo_btn:
                clearBottomImageState();
                selectDisplayView(2);
                break;
            default:
                break;


        }
    }

    private void setListener(){
        for(int i = 0;i<mBottomLayout.getChildCount();i++){
            mBottomLayout.getChildAt(i).setOnClickListener(this);
        }
    }

    private void clearBottomImageState(){
        tv_course.setTextColor(Color.parseColor("#666666"));
        tv_exercises.setTextColor(Color.parseColor("#666666"));
        tv_myInfo.setTextColor(Color.parseColor("#666666"));
        iv_course.setImageResource(R.drawable.main_course_icon);
        iv_exercises.setImageResource(R.drawable.main_exercises_icon);
        iv_myInfo.setImageResource(R.drawable.main_my_icon);
        for(int i = 0;i<mBottomLayout.getChildCount();i++){
            mBottomLayout.getChildAt(i).setSelected(false);
        }
    }


    private void setSelectStatus(int index){
        switch(index){
            case 0:
                mCourseBtn.setSelected(true);
                iv_course.setImageResource(R.drawable.main_course_icon_selector);
                tv_course.setTextColor(Color.parseColor("#0097F7"));

                break;

            case 1:
                mExerciseBtn.setSelected(true);
                iv_exercises.setImageResource(R.drawable.main_exercises_icon_selected);
                tv_exercises.setTextColor(Color.parseColor("#0097F7"));

                break;

            case 2:
                mMyInfoBtn.setSelected(true);
                iv_myInfo.setImageResource(R.drawable.main_my_icon_selected);
                tv_myInfo.setTextColor(Color.parseColor("#0097F7"));


                break;
        }
    }
    private void removeAllView(){
        for(int i = 0;i<mBodyLayout.getChildCount();i++){
            mBodyLayout.getChildAt(i).setVisibility(View.GONE);
        }
    }
    /*
    设置界面view的初始化状态
     */
        private void setInitStatus(){
            clearBottomImageState();
            setSelectStatus(2);
            createView(2);
    }
    private void selectDisplayView(int index){
        removeAllView();
        createView(index);
        setSelectStatus(index);
    }
    private void createView(int viewIndex){
        switch (viewIndex){
            case 0:
                //课程界面
                if (vi1 == null){
                    vi1 = new view1(this);
                    mBodyLayout.addView(vi1.getView());
                }else{
                    vi1.getView();

                }
                vi1.showView();
                break;
            case 1:
                //习题界面
                if (vi2 == null){
                    vi2 = new view2(this);
                    mBodyLayout.addView(vi2.getView());
                }else{
                    vi2.getView();

                }
                vi2.showView();
                break;
            case 2:
                if (vi3 == null){
                    vi3 = new view3(this);
                    mBodyLayout.addView(vi3.getView());
                }else{
                    vi3.getView();

                }
                vi3.showView();
                break;

        }
    }



}

