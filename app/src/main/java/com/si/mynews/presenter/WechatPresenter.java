package com.si.mynews.presenter;

import com.si.mynews.base.RxPresenter;
import com.si.mynews.model.bean.WXItemBean;
import com.si.mynews.model.http.RetrofitHelper;
import com.si.mynews.model.http.response.WXHttpResponse;
import com.si.mynews.presenter.contract.WechatContract;
import com.si.mynews.util.RxUtil;

import java.util.List;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by si on 16/8/29.
 */

public class WechatPresenter extends RxPresenter<WechatContract.View> implements WechatContract.Presenter {

    private static final int NUM_OF_PAGE = 20;

    private int currentPage = 1;
    private String queryStr = null;

    private RetrofitHelper mRetrofitHelper;

    @Inject
    public WechatPresenter(RetrofitHelper mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }

    @Override
    public void getWechatData() {
        queryStr = null;
        currentPage = 1;
        Subscription rxSubscription = mRetrofitHelper.fetchWechatListInfo(NUM_OF_PAGE, currentPage)
                .compose(RxUtil.<WXHttpResponse<List<WXItemBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<WXItemBean>>handleWXResult())
                .subscribe(new Action1<List<WXItemBean>>() {
                    @Override
                    public void call(List<WXItemBean> wxItemBeen) {
                        mView.showContent(wxItemBeen);
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
    public void getMoreWechatData() {
        Subscription subscribe = mRetrofitHelper.fetchWechatListInfo(NUM_OF_PAGE, ++currentPage).compose(RxUtil.<WXHttpResponse<List<WXItemBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<WXItemBean>>handleWXResult())
                .subscribe(new Action1<List<WXItemBean>>() {
                    @Override
                    public void call(List<WXItemBean> wxItemBeen) {
                        mView.showMoreContent(wxItemBeen);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.showError("没有更多了ヽ(≧Д≦)ノ");
                    }
                });
        addSubscrebe(subscribe);
    }
}
