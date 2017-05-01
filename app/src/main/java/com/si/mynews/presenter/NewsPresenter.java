package com.si.mynews.presenter;

import com.si.mynews.base.RxPresenter;
import com.si.mynews.model.bean.NewsListBean;
import com.si.mynews.model.http.RetrofitHelper;
import com.si.mynews.presenter.contract.NewsContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by si on 16/11/27.
 */

public class NewsPresenter extends RxPresenter<NewsContract.View> implements NewsContract.Presenter{

    private static final int NUM_EACH_PAGE = 20;
    private static final int NUM_HOT_LIMIT = 3;

    private RetrofitHelper mRetrofitHelper;
    private List<NewsListBean> totalList = new ArrayList<>();

    private boolean isHotList = true;
    private int currentPage = 0;
    private String mType;

    @Inject
    public NewsPresenter(RetrofitHelper mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }

    @Override
    public void getGoldData(String type) {

    }

    @Override
    public void getMoreGoldData() {

    }
}
