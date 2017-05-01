package com.si.mynews.fragment;

import com.si.mynews.base.BaseFragment;
import com.si.mynews.model.bean.NewsListBean;
import com.si.mynews.model.bean.NewsTopListBean;
import com.si.mynews.presenter.NewsPresenter;
import com.si.mynews.presenter.contract.NewsContract;

import java.util.List;

import si.mynews.R;

/**
 * Created by si on 16/11/27.
 */

public class NewsPagerFragment extends BaseFragment<NewsPresenter> implements NewsContract.View {

    private boolean isLoadingMore = false;
    private String mType;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.view_common_list;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showTopContent(List<NewsTopListBean.DataBean> newsTopListBeen) {

    }

    @Override
    public void doInterval(int currentCount) {

    }

    @Override
    public void showContent(List<NewsListBean.ListBean> newsListBean) {

    }

    @Override
    public void showMoreContent(List<NewsListBean.ListBean> newsMoreListBean, int start, int end) {

    }
}
