package com.si.mynews.presenter.contract;

import com.si.mynews.base.BasePresenter;
import com.si.mynews.model.bean.WXItemBean;

import java.util.List;

/**
 * Created by si on 16/8/29.
 */

public interface WechatContract {

    interface View extends BaseView {

        void showContent(List<WXItemBean> mList);

        void showMoreContent(List<WXItemBean> mList);
    }

    interface Presenter extends BasePresenter<View> {

        void getWechatData();

        void getMoreWechatData();
    }
}
