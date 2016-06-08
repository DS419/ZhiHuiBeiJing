package com.wonder.zhihuibeijing;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.wonder.zhihuibeijing.fragment.ContentFragment;
import com.wonder.zhihuibeijing.fragment.LeftMenuFragment;

/**
 * Created by 13036 on 2016/6/6.
 */
public class MainActivity extends SlidingFragmentActivity{

    private static final String TAG_LEFT_MENU = "TAG_LEFT_MENU";

    private static final String TAG_CONTENT = "TAG_CONTENT";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        setBehindContentView(R.layout.left_menu);
        SlidingMenu slidingMenu = getSlidingMenu();
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setBehindOffset(600);

        initFragment();
    }

    public void initFragment() {
        FragmentManager fragmentManager=  getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_main, new ContentFragment(), TAG_CONTENT);
        transaction.replace(R.id.fl_left_menu, new LeftMenuFragment(), TAG_LEFT_MENU);
        transaction.commit();
    }
}
