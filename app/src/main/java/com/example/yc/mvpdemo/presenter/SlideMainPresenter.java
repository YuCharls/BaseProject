package com.example.yc.mvpdemo.presenter;

import android.support.v4.app.FragmentTransaction;

import com.example.yc.mvpdemo.R;
import com.example.yc.mvpdemo.activity.SlideMainActivity;
import com.example.yc.mvpdemo.base.BasePresenter;
import com.example.yc.mvpdemo.contract.SlideMainContract;
import com.example.yc.mvpdemo.fragment.Fragment1;
import com.example.yc.mvpdemo.fragment.Fragment2;
import com.example.yc.mvpdemo.fragment.Fragment3;
import com.example.yc.mvpdemo.fragment.Fragment4;

/**
 * Created by YuChao
 * com.example.yc.mvpdemo.presenter
 */

public class SlideMainPresenter extends BasePresenter<SlideMainActivity> implements
        SlideMainContract.SlideMainPresenter {
    
    private static final String TAG = "SlideMainPresenter";


    private Fragment1 mainFragment1;//查运价
    private Fragment2 mainFragment2;
    private Fragment3 mainFragment3;
    private Fragment4 mainFragment4;
    private int mSelectedTab;

    @Override
    public void showFragment(int viewId) {
        if (mSelectedTab == viewId) {
            return;
        }
        mSelectedTab = viewId;
        FragmentTransaction ft = getIView().getSupportFragmentManager().beginTransaction();

        switch (mSelectedTab) {
            //查运价
            case R.id.wddd_item:
                mainFragment1 = (Fragment1) getIView().getSupportFragmentManager().findFragmentByTag("item1");
                if (mainFragment1 == null) {
                    mainFragment1 = new Fragment1(getIView());
                }

                if (!mainFragment1.isAdded()) {
                    ft.add(R.id.content_frame, mainFragment1, "item1");
                }

                ft.show(mainFragment1);
                if (null != mainFragment3) {
                    ft.hide(mainFragment3);
                }
                if (null != mainFragment2) {
                    ft.hide(mainFragment2);
                }
                if (null != mainFragment4) {
                    ft.hide(mainFragment4);
                }
                ft.commit();
                break;

            //发车
            case R.id.fkw_item:
                mainFragment2 = (Fragment2) getIView().getSupportFragmentManager().findFragmentByTag("item2");
                if (mainFragment2 == null) {
                    mainFragment2 = new Fragment2(getIView());
                }

                if (!mainFragment2.isAdded()) {
                    ft.add(R.id.content_frame, mainFragment2, "item2");
                }

                ft.show(mainFragment2);
                if (null != mainFragment1) {
                    ft.hide(mainFragment1);
                }
                if (null != mainFragment3) {
                    ft.hide(mainFragment3);
                }
                if (null != mainFragment4) {
                    ft.hide(mainFragment4);
                }
                ft.commit();
                break;

            //看订单
            case R.id.wdzx_item:
                mainFragment3 = (Fragment3) getIView().getSupportFragmentManager().findFragmentByTag("item3");
                if (mainFragment3 == null) {
                    mainFragment3 = new Fragment3(getIView());
                }

                if (!mainFragment3.isAdded()) {
                    ft.add(R.id.content_frame, mainFragment3, "item3");
                }

                ft.show(mainFragment3);
                if (null != mainFragment1) {
                    ft.hide(mainFragment1);
                }
                if (null != mainFragment2) {
                    ft.hide(mainFragment2);
                }
                if (null != mainFragment4) {
                    ft.hide(mainFragment4);
                }
                ft.commit();
                break;


            //抢空位
            case R.id.wdcy_item:
                mainFragment4 = (Fragment4) getIView().getSupportFragmentManager().findFragmentByTag("item4");
                if (mainFragment4 == null) {
                    mainFragment4 = new Fragment4(getIView());
                }

                if (!mainFragment4.isAdded()) {
                    ft.add(R.id.content_frame, mainFragment4, "item4");
                }


                ft.show(mainFragment4);
                if (null != mainFragment1) {
                    ft.hide(mainFragment1);
                }
                if (null != mainFragment2) {
                    ft.hide(mainFragment2);
                }
                if (null != mainFragment3) {
                    ft.hide(mainFragment3);
                }

                ft.commit();
                break;
        }
    }
}
