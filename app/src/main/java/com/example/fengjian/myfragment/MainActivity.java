package com.example.fengjian.myfragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private ConstraintLayout mTabWeiXin;
    private ConstraintLayout mTabContactors;
    private ConstraintLayout mTabFounds;
    private ConstraintLayout mTabAboutMe;

    private Fragment mWeChatFrag;
    private Fragment mContractorsFrag;
    private Fragment mFoundsFrag;
    private Fragment mAboutMeFrag;

    private ImageView mWeChatImg;
    private ImageView mContractorsImg;
    private ImageView mFoundsImg;
    private ImageView mAboutMeImg;

    private TextView mWeChatTv;
    private TextView mContractorsTv;
    private TextView mFoundsTv;
    private TextView mAboutMeTv;

    private List<Fragment> fragments;
    private ViewPager viewPager;

    private int tabLineLength;
    private int currentPage=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initTabLine();
        initViews();
        initAdapter();
        initListensers();
        viewPager.setCurrentItem(0);
        mWeChatTv.setTextColor(Color.BLUE);

    }

    private void initTabLine(){
        Display display=getWindow().getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics=new DisplayMetrics();
        display.getMetrics(metrics);
        tabLineLength=metrics.widthPixels/3;
    }

    private void initAdapter(){
        viewPager=(ViewPager)findViewById(R.id.id_viewpager);
        fragments=new ArrayList<Fragment>();
        fragments.add(mWeChatFrag);
        fragments.add(mContractorsFrag);
        fragments.add(mFoundsFrag);
        fragments.add(mAboutMeFrag);
        MyFragPagerAdapter adapter=new MyFragPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                initIcon();
                setColor(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initViews(){
        mWeChatFrag=new WeChatFragment();
        mContractorsFrag=new ContactorsFragment();
        mFoundsFrag=new FoundsFragment();
        mAboutMeFrag=new AboutMeFragment();

        mWeChatImg=(ImageView)findViewById(R.id.id_ly_bottombar).findViewById(R.id.icon1).findViewById(R.id.icon);
        mWeChatImg.setBackgroundResource(R.drawable.icon_message);
        mWeChatTv=(TextView)findViewById(R.id.id_ly_bottombar).findViewById(R.id.icon1).findViewById(R.id.icon_des);
        mWeChatTv.setText("微信");

        mContractorsImg=(ImageView)findViewById(R.id.id_ly_bottombar).findViewById(R.id.icon2).findViewById(R.id.icon);
        mContractorsImg.setBackgroundResource(R.drawable.icon_contractors);
        mContractorsTv=(TextView)findViewById(R.id.id_ly_bottombar).findViewById(R.id.icon2).findViewById(R.id.icon_des);
        mContractorsTv.setText("通讯录");

        mFoundsImg=(ImageView)findViewById(R.id.id_ly_bottombar).findViewById(R.id.icon3).findViewById(R.id.icon);
        mFoundsImg.setBackgroundResource(R.drawable.icon_founds);
        mFoundsTv=(TextView)findViewById(R.id.id_ly_bottombar).findViewById(R.id.icon3).findViewById(R.id.icon_des);
        mFoundsTv.setText("发现");


        mAboutMeImg=(ImageView)findViewById(R.id.id_ly_bottombar).findViewById(R.id.icon4).findViewById(R.id.icon);
        mAboutMeImg.setBackgroundResource(R.drawable.icon_me);
        mAboutMeTv=(TextView)findViewById(R.id.id_ly_bottombar).findViewById(R.id.icon4).findViewById(R.id.icon_des);
        mAboutMeTv.setText("我");

        mTabWeiXin=(ConstraintLayout)findViewById(R.id.id_ly_bottombar).findViewById(R.id.icon1);
        mTabContactors=(ConstraintLayout)findViewById(R.id.id_ly_bottombar).findViewById(R.id.icon2);
        mTabFounds=(ConstraintLayout)findViewById(R.id.id_ly_bottombar).findViewById(R.id.icon3);
        mTabAboutMe=(ConstraintLayout)findViewById(R.id.id_ly_bottombar).findViewById(R.id.icon4);
    }

    private void initListensers(){
        mTabWeiXin.setOnClickListener(this);
        mTabContactors.setOnClickListener(this);
        mTabFounds.setOnClickListener(this);
        mTabAboutMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        initIcon();
        switch (view.getId()){
            case R.id.icon1:
                viewPager.setCurrentItem(0);
                setColor(0);
                break;
            case R.id.icon2:
                viewPager.setCurrentItem(1);
                setColor(1);
                break;
            case R.id.icon3:
                viewPager.setCurrentItem(2);
                setColor(2);
                break;
            case R.id.icon4:
                viewPager.setCurrentItem(3);
                setColor(3);
                break;
            default:
                break;
        }
    }

    private void initIcon(){
        mWeChatTv.setTextColor(Color.BLACK);
        mContractorsTv.setTextColor(Color.BLACK);
        mFoundsTv.setTextColor(Color.BLACK);
        mAboutMeTv.setTextColor(Color.BLACK);
    }

    private void setColor(int i){
        switch (i){
            case 0:
                mWeChatTv.setTextColor(Color.BLUE);
                break;
            case 1:
                mContractorsTv.setTextColor(Color.BLUE);
                break;
            case 2:
                mFoundsTv.setTextColor(Color.BLUE);
                break;
            case 3:
                mAboutMeTv.setTextColor(Color.BLUE);
                break;
            default:
                break;
        }
    }

}
