package com.si.mynews.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.si.mynews.adapter.NewsPagerAdapter;
import com.si.mynews.app.Constants;
import com.si.mynews.base.BaseFragment;

import com.si.mynews.model.bean.NewsManagerBean;
import com.si.mynews.model.bean.NewsManagerItemBean;
import com.si.mynews.presenter.NewsMainPresenter;
import com.si.mynews.presenter.contract.NewsMainContract;
import com.si.mynews.ui.NewsManagerActivity;
import com.si.mynews.util.SnackbarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import si.mynews.R;

public class NewsMainFragment extends BaseFragment<NewsMainPresenter> implements NewsMainContract.View {

    @BindView(R.id.tab_news_main)
    TabLayout mTabLayout;
    @BindView(R.id.vp_news_main)
    ViewPager mViewPager;

    public static String[] typeStr = {"Android", "iOS", "前端", "后端", "设计", "产品", "阅读", "工具资源"};
    public static String[] type = {"android", "ios", "frontend", "backend", "design", "product", "article", "freebie"};

    List<NewsPagerFragment> fragments = new ArrayList<>();
    private int currentIndex = 0;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frgament_news_main;
    }

    @Override
    protected void initEventAndData() {
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setupWithViewPager(mViewPager);
        mPresenter.initManagerList();
    }

    @Override
    public void updateTab(List<NewsManagerItemBean> mList) {
        fragments.clear();
        mTabLayout.removeAllTabs();
        for (NewsManagerItemBean item : mList) {
            if (item.getIsSelect()) {
                NewsPagerFragment fragment = new NewsPagerFragment();
                Bundle bundle = new Bundle();
                bundle.putString(Constants.IT_NEWS_TYPE, item.getType());
                bundle.putInt(Constants.IT_PAGE_TYPE, item.getPageType());
                mTabLayout.addTab(mTabLayout.newTab().setText(item.getType()));
                fragment.setArguments(bundle);
                fragments.add(fragment);
            }
        }
        NewsPagerAdapter mAdapter = new NewsPagerAdapter(getChildFragmentManager(), fragments);
        mViewPager.setAdapter(mAdapter);
        for (NewsManagerItemBean item : mList) {
            if (item.getIsSelect()) {
                mTabLayout.getTabAt(currentIndex++).setText(item.getType());
            }
        }
        currentIndex = 0;
    }

    @Override
    public void jumpToManager(NewsManagerBean mBean) {
        Intent intent = new Intent(getActivity(), NewsManagerActivity.class);
        intent.putExtra(Constants.IT_NEWS_MANAGER, mBean);
        mContext.startActivity(intent);
    }

    @Override
    public void showError(String msg) {
        SnackbarUtil.showShort(mTabLayout, msg);
    }

    @OnClick(R.id.iv_news_menu)
    public void onClick(View view) {
        mPresenter.setManagerList();
    }
}
