package cn.edu.gdmec.android;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by apple on 18/3/27.
 */

public class view2 {
    private Activity mContext;
    private LayoutInflater mInflater;
    private View mCurrentView;
    private TextView tv1;

    public view2(Activity context){
        mContext=context;
        //为之后将Layout转化为view时用
        mInflater=LayoutInflater.from(mContext);
    }

    private void createView(){
        initView();
    }


    private void initView() {

        mCurrentView = mInflater.inflate(R.layout.layout1, null);
        tv1=mCurrentView.findViewById(R.id.tv1);
        tv1.setText("FrameLayout_2");
    }


    //获取当前在导航栏上方显示对应的View
    public View getView(){
        if(mCurrentView==null){
            createView();
        }
        return mCurrentView;
    }

    //获取当前在导航栏上方显示对应的View界面

    public void showView(){
        if (mCurrentView==null){
            createView();
        }
        mCurrentView.setVisibility(View.VISIBLE);
    }
}
