package com.wonder.zhihuibeijing.fragment;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.wonder.zhihuibeijing.R;
import com.wonder.zhihuibeijing.base.BasePager;
import com.wonder.zhihuibeijing.base.impl.GovAffairsPager;
import com.wonder.zhihuibeijing.base.impl.HomePager;
import com.wonder.zhihuibeijing.base.impl.NewsCenterPager;
import com.wonder.zhihuibeijing.base.impl.SettingPager;
import com.wonder.zhihuibeijing.base.impl.SmartServicePager;
import com.wonder.zhihuibeijing.view.NoScrollViewPager;

import java.util.ArrayList;

/**
 * Created by 13036 on 2016/6/9.
 */
public class ContentFragment extends BaseFragment {

    private NoScrollViewPager mViewPager;

    private ArrayList<BasePager> mPagers;

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_content, null);

        mViewPager = (NoScrollViewPager) view.findViewById(R.id.vp_content);

        return view;
    }

    @Override
    public void initData() {
        mPagers = new ArrayList<BasePager>();
        mPagers.add(new HomePager(mActivity));
        mPagers.add(new NewsCenterPager(mActivity));
        mPagers.add(new SmartServicePager(mActivity));
        mPagers.add(new GovAffairsPager(mActivity));
        mPagers.add(new SettingPager(mActivity));
        mViewPager.setAdapter(new ContentAdapter());
    }

    class ContentAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mPagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager pager = mPagers.get(position);
            View view = pager.mRootView;
            pager.initData();
            container.addView(view);

            return view;
        }
    }
}
