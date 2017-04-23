package com.si.mynews.presenter;

import com.si.mynews.base.RxPresenter;
import com.si.mynews.model.bean.NewsListBean;

import com.si.mynews.model.http.RetrofitHelper;
import com.si.mynews.model.http.response.NewsHttpResponse;
import com.si.mynews.presenter.contract.NewsContract;
import com.si.mynews.util.RxUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
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
    public void getNewsData(String type) {
        mType = type;
        currentPage = 0;
        totalList.clear();
        Observable<List<NewsListBean>> list = mRetrofitHelper.fetchNewsList(NUM_EACH_PAGE)
                .compose(RxUtil.<NewsHttpResponse<List<NewsListBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<NewsListBean>>handleNewsResult());

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -3);

        Observable<List<NewsListBean>> hotList = mRetrofitHelper.fetchNewsHotList(type,
                new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()), NUM_HOT_LIMIT)
                .compose(RxUtil.<NewsHttpResponse<List<NewsListBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<NewsListBean>>handleNewsResult());

        Subscription rxSubscription = Observable.concat(hotList, list).subscribe(new Action1<List<NewsListBean>>() {
            @Override
            public void call(List<NewsListBean> newsListBean) {
                if (isHotList) {
                    isHotList = false;
                    totalList.addAll(newsListBean);
                } else {
                    isHotList = true;
                    totalList.addAll(newsListBean);
                    mView.showContent(totalList);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                mView.showError("数据加载失败ヽ(≧Д≦)ノ");
            }
        });
        addSubscrebe(rxSubscription);
    }

    @Override
    public void getMoreNewsData() {
        Subscription rxSubscription = mRetrofitHelper.fetchNewsList(NUM_EACH_PAGE)
                .compose(RxUtil.<NewsHttpResponse<List<NewsListBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<NewsListBean>>handleNewsResult())
                .subscribe(new Action1<List<NewsListBean>>() {
                    @Override
                    public void call(List<NewsListBean> newsListBeen) {
                        totalList.addAll(newsListBeen);
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
