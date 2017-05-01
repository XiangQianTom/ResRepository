package com.si.mynews.presenter;

import com.si.mynews.base.RxPresenter;
import com.si.mynews.model.bean.NewsListBean;
import com.si.mynews.model.http.RetrofitHelper;
import com.si.mynews.presenter.contract.NewsContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscription;

/**
 * Created by si on 16/11/27.
 */

public class NewsPresenter extends RxPresenter<NewsContract.View> implements NewsContract.Presenter {

    private static final int NUM_EACH_PAGE = 20;
    private static final int NUM_HOT_LIMIT = 3;

    private RetrofitHelper mRetrofitHelper;
    private List<NewsListBean.ListBean> totalList = new ArrayList<>();
    private boolean isHotList = true;
    private int currentPage = 0;
    private String mType;
    private static final int INTERVAL_INSTANCE = 6;
    private Subscription intervalSubscription;
    private int topCount = 0;
    private int currentTopCount = 0;

    @Inject
    public NewsPresenter(RetrofitHelper mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }

    @Override
    public void getNewsTopData(String newsType) {
        getScrollTopData(newsType);
    }

    @Override
    public void startInterval() {

    }

    @Override
    public void stopInterval() {

    }

    @Override
    public void getNewsData(String type) {

    }

    @Override
    public void getMoreNewsData() {

    }

    private void getScrollTopData(String newsType) {
        switch (newsType) {
            case "头条":
                getScrollTopList("top");
                break;
            case "财经":
                getScrollTopList("caijing");
                break;
            case "体育":
                getScrollTopList("tiyu");
                break;
            case "娱乐":
                getScrollTopList("yule");
                break;
            case "军事":
                getScrollTopList("junshi");
                break;
            case "科技":
                getScrollTopList("keji");
                break;
        }
    }

    private void getScrollTopList(String type) {

    }
}
