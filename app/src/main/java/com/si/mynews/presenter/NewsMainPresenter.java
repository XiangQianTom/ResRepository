package com.si.mynews.presenter;

import com.si.mynews.base.RxPresenter;
import com.si.mynews.component.RxBus;
import com.si.mynews.model.bean.NewsManagerBean;
import com.si.mynews.model.bean.NewsManagerItemBean;
import com.si.mynews.model.db.RealmHelper;
import com.si.mynews.presenter.contract.NewsMainContract;
import com.si.mynews.util.RxUtil;

import javax.inject.Inject;

import io.realm.RealmList;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by si on 16/11/28.
 */

public class NewsMainPresenter extends RxPresenter<NewsMainContract.View> implements NewsMainContract.Presenter{

    private RealmHelper mRealmHelper;
    private RealmList<NewsManagerItemBean> mList;

    @Inject
    public NewsMainPresenter(RealmHelper mRealHelper) {
        this.mRealmHelper = mRealHelper;
        registerEvent();
    }

    private void registerEvent() {
        Subscription rxSubscription = RxBus.getDefault().toObservable(NewsManagerBean.class)
                .compose(RxUtil.<NewsManagerBean>rxSchedulerHelper())
                .subscribe(new Action1<NewsManagerBean>() {
                    @Override
                    public void call(NewsManagerBean goldManagerBean) {
                        mRealmHelper.updateNewsManagerList(goldManagerBean);
                        mView.updateTab(goldManagerBean.getManagerList());
                    }
                });
        addSubscrebe(rxSubscription);
    }

    @Override
    public void initManagerList() {

    }

    @Override
    public void setManagerList() {

    }

    private void initList() {
    }
}
