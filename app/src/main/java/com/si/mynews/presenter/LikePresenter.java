package com.si.mynews.presenter;

import com.si.mynews.base.RxPresenter;
import com.si.mynews.model.db.RealmHelper;
import com.si.mynews.presenter.contract.LikeContract;

import javax.inject.Inject;

/**
 * Created by si on 2016/8/23.
 */
public class LikePresenter extends RxPresenter<LikeContract.View> implements LikeContract.Presenter{

    private RealmHelper mRealmHelper;

    @Inject
    public LikePresenter(RealmHelper mRealmHelper) {
        this.mRealmHelper = mRealmHelper;
    }

    @Override
    public void getLikeData() {
        mView.showContent(mRealmHelper.getLikeList());
    }

    @Override
    public void deleteLikeData(String id) {
        mRealmHelper.deleteLikeBean(id);
    }

    @Override
    public void changeLikeTime(String id, long time, boolean isPlus) {
        mRealmHelper.changeLikeTime(id,time,isPlus);
    }
}
