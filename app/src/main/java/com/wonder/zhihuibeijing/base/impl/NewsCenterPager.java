package com.wonder.zhihuibeijing.base.impl;

import android.app.Activity;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.wonder.zhihuibeijing.base.BasePager;
import com.wonder.zhihuibeijing.domain.NewsMenu;
import com.wonder.zhihuibeijing.global.GlobalConstants;
import com.wonder.zhihuibeijing.utils.CacheUtils;

/**
 * Created by 13036 on 2016/6/10.
 */
public class NewsCenterPager extends BasePager{
    public NewsCenterPager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        Log.d("NewsCenterPager", "新闻中心初始化");
        TextView view = new TextView(mActivity);
        view.setText("新闻中心");
        view.setTextColor(Color.RED);
        view.setTextSize(22);
        view.setGravity(Gravity.CENTER);
        view.setVisibility(View.VISIBLE);

        flContent.addView(view);

        tvTitle.setText("新闻");
        btnMenu.setVisibility(View.VISIBLE);

        String cache = CacheUtils.getCache(GlobalConstants.CATEGORY_URL, mActivity);
        if (!TextUtils.isEmpty(cache)) {
            Log.d("NewsCenterPager", "发现缓存！！！");
            processData(cache);
        }

        getDataFromServer();
    }

    private void getDataFromServer() {
        HttpUtils utils = new HttpUtils();
        utils.send(HttpRequest.HttpMethod.GET, GlobalConstants.CATEGORY_URL, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                Log.d("NewsCenterPager", String.valueOf(responseInfo.result));
                processData(responseInfo.result);
                CacheUtils.setCache(GlobalConstants.CATEGORY_URL, responseInfo.result, mActivity);
            }

            @Override
            public void onFailure(HttpException e, String s) {
                e.printStackTrace();
                Toast.makeText(mActivity, s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void processData(String result) {
        Gson gson = new Gson();
        NewsMenu data = gson.fromJson(result, NewsMenu.class);
        Log.d("NewsCenterPager", String.valueOf(data));
    }
}
