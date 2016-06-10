package com.wonder.zhihuibeijing.base;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.wonder.zhihuibeijing.R;

/**五个便签页的基类
 * Created by 13036 on 2016/6/10.
 */
public class BasePager {

    public Activity mActivity;

    public TextView tvTitle;

    public ImageButton btnMenu;

    public FrameLayout flContent;

    public View mRootView;

    public BasePager(Activity activity) {
        this.mActivity = activity;
        mRootView = initView();
    }

    public View initView() {
        View view = View.inflate(mActivity, R.layout.base_pager, null);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        btnMenu = (ImageButton) view.findViewById(R.id.btn_menu);
        flContent = (FrameLayout) view.findViewById(R.id.fl_content);

        return view;
    }

    public void initData() {

    }
}
