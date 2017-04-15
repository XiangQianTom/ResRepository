package com.si.mynews.presenter;


import android.util.Log;

import com.si.mynews.base.RxPresenter;
import com.si.mynews.base.WelcomeContract;
import com.si.mynews.model.bean.WelcomeBean;
import com.si.mynews.model.http.RetrofitHelper;
import com.si.mynews.util.RxUtil;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by codeest on 16/8/15.
 */

public class WelcomePresenter extends RxPresenter<WelcomeContract.View> implements WelcomeContract.Presenter {

    private static final String RES = "1080*1776";

    private static final int COUNT_DOWN_TIME = 2200;

    private RetrofitHelper mRetrofitHelper;

    private static final String TAG = WelcomePresenter.class.getSimpleName();

    @Inject
    public WelcomePresenter(RetrofitHelper mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }

    @Override
    public void getWelcomeData() {
        Subscription rxSubscription = mRetrofitHelper.fetchWelcomeInfo(RES)
                .compose(RxUtil.<WelcomeBean>rxSchedulerHelper())
                .subscribe(new Action1<WelcomeBean>() {
                    @Override
                    public void call(WelcomeBean welcomeBean) {
                        Log.e(TAG, "111111111111111111111111");
                        mView.showContent(welcomeBean);
                        startCountDown();
                        Log.e(TAG, "2222222222222222222222222");
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e(TAG, "333333333333333333");
                        mView.jumpToMain();
                        Log.e(TAG, "444444444444444444");
                    }
                });
        addSubscrebe(rxSubscription);
    }

    private void startCountDown() {
        Subscription rxSubscription = Observable.timer(COUNT_DOWN_TIME, TimeUnit.MILLISECONDS)
                .compose(RxUtil.<Long>rxSchedulerHelper())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        mView.jumpToMain();
                    }
                });
        addSubscrebe(rxSubscription);
    }
}
