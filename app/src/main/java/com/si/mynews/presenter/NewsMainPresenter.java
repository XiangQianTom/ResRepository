package com.si.mynews.presenter;

import com.si.mynews.base.RxPresenter;
import com.si.mynews.component.RxBus;
import com.si.mynews.model.bean.GoldManagerBean;
import com.si.mynews.model.bean.GoldManagerItemBean;
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
    private RealmList<GoldManagerItemBean> mList;

    @Inject
    public NewsMainPresenter(RealmHelper mRealHelper) {
        this.mRealmHelper = mRealHelper;
        registerEvent();
    }

    private void registerEvent() {
        Subscription rxSubscription = RxBus.getDefault().toObservable(GoldManagerBean.class)
                .compose(RxUtil.<GoldManagerBean>rxSchedulerHelper())
                .subscribe(new Action1<GoldManagerBean>() {
                    @Override
                    public void call(GoldManagerBean goldManagerBean) {
                        mRealmHelper.updateGoldManagerList(goldManagerBean);
                        mView.updateTab(goldManagerBean.getManagerList());
                    }
                });
        addSubscrebe(rxSubscription);
    }

    @Override
    public void initManagerList() {
        if (SharedPreferenceUtil.getManagerPoint()) {
            //第一次使用，生成默认ManagerList
            initList();
            mRealmHelper.updateGoldManagerList(new GoldManagerBean(mList));
            mView.updateTab(mList);
        } else {
            if (mRealmHelper.getGoldManagerList() == null) {
                initList();
                mRealmHelper.updateGoldManagerList(new GoldManagerBean(mList));
            } else {
                mList = mRealmHelper.getGoldManagerList().getManagerList();
            }
            mView.updateTab(mList);
        }
    }

    @Override
    public void setManagerList() {
        mView.jumpToManager(mRealmHelper.getGoldManagerList());
    }

    private void initList() {
        mList = new RealmList<>();
        mList.add(new GoldManagerItemBean(0, true));
        mList.add(new GoldManagerItemBean(1, true));
        mList.add(new GoldManagerItemBean(2, true));
        mList.add(new GoldManagerItemBean(3, true));
        mList.add(new GoldManagerItemBean(4, false));
        mList.add(new GoldManagerItemBean(5, false));
        mList.add(new GoldManagerItemBean(6, false));
        mList.add(new GoldManagerItemBean(7, false));
    }
}
