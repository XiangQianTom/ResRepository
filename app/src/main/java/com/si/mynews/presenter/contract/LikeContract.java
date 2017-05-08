package com.si.mynews.presenter.contract;

import com.si.mynews.base.BasePresenter;
import com.si.mynews.model.bean.RealmLikeBean;

import java.util.List;

public interface LikeContract {

    interface View extends BaseView {

        void showContent(List<RealmLikeBean> mList);
    }

    interface Presenter extends BasePresenter<View> {

        void getLikeData();

        void deleteLikeData(String id);

        void changeLikeTime(String id, long time, boolean isPlus);
    }
}
