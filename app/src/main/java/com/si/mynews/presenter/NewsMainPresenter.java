package com.si.mynews.presenter;

import com.si.mynews.base.RxPresenter;
import com.si.mynews.component.RxBus;
import com.si.mynews.model.bean.NewsManagerBean;
import com.si.mynews.model.bean.NewsManagerItemBean;
import com.si.mynews.model.db.RealmHelper;
import com.si.mynews.presenter.contract.NewsMainContract;
import com.si.mynews.util.RxUtil;
import com.si.mynews.util.SharedPreferenceUtil;

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
                    public void call(NewsManagerBean newsManagerBean) {
                        mRealmHelper.updateNewsManagerList(newsManagerBean);
                        mView.updateTab(newsManagerBean.getManagerList());
                    }
                });
        addSubscrebe(rxSubscription);
    }

    @Override
    public void initManagerList() {
        if (SharedPreferenceUtil.getManagerPoint()) {
            //第一次使用，生成默认ManagerList
            initList();
            mRealmHelper.updateNewsManagerList(new NewsManagerBean(mList));
            mView.updateTab(mList);
        } else {
            if (mRealmHelper.getNewsManagerList() == null) {
                initList();
                mRealmHelper.updateNewsManagerList(new NewsManagerBean(mList));
            } else {
                mList = mRealmHelper.getNewsManagerList().getManagerList();
            }
            mView.updateTab(mList);
        }
    }

    @Override
    public void setManagerList() {
        mView.jumpToManager(mRealmHelper.getNewsManagerList());
    }

    private void initList() {
        mList = new RealmList<>();
        mList.add(new NewsManagerItemBean(0, true));
        mList.add(new NewsManagerItemBean(1, true));
        mList.add(new NewsManagerItemBean(2, true));
        mList.add(new NewsManagerItemBean(3, true));
        mList.add(new NewsManagerItemBean(4, false));
        mList.add(new NewsManagerItemBean(5, false));
        mList.add(new NewsManagerItemBean(6, false));
        mList.add(new NewsManagerItemBean(7, false));
    }
}
