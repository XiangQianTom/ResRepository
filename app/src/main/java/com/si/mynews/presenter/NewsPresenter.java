package com.si.mynews.presenter;

import com.si.mynews.base.RxPresenter;
import com.si.mynews.model.bean.NewsListBean;
import com.si.mynews.model.http.RetrofitHelper;
import com.si.mynews.model.http.response.NewsHttpResponse;
import com.si.mynews.presenter.contract.NewsContract;
import com.si.mynews.util.RxUtil;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

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
        Subscription rxSubscription = mRetrofitHelper.fetchNewsList(currentPage++)
                .compose(RxUtil.<NewsHttpResponse<List<NewsListBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<NewsListBean>>handleGoldResult())
                .subscribe(new Action1<List<NewsListBean>>() {
                    @Override
                    public void call(List<NewsListBean> goldListBeen) {
                        totalList.addAll(goldListBeen);
                        mView.showMoreContent(totalList, totalList.size(), totalList.size() + NUM_EACH_PAGE);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.showError("数据加载失败ヽ(≧Д≦)ノ");
                    }
                });
        addSubscrebe(rxSubscription);
    }
}
