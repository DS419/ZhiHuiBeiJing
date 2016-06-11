package com.wonder.zhihuibeijing.base.impl;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.wonder.zhihuibeijing.base.BasePager;

/**
 * Created by 13036 on 2016/6/10.
 */
public class SettingPager extends BasePager{
    public SettingPager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        Log.d("SettingPager", "设置初始化");
        TextView view = new TextView(mActivity);
        view.setText("设置");
        view.setTextColor(Color.RED);
        view.setTextSize(22);
        view.setGravity(Gravity.CENTER);

        flContent.addView(view);

        tvTitle.setText("设置");
        btnMenu.setVisibility(View.GONE);
    }
}
