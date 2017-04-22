package com.si.mynews.presenter.contract;


import com.si.mynews.base.BasePresenter;
import com.si.mynews.model.bean.NewsManagerBean;
import com.si.mynews.model.bean.NewsManagerItemBean;

import java.util.List;

/**
 * Created by si on 16/11/28.
 */

public interface NewsMainContract {

    interface View extends BaseView {

        void updateTab(List<NewsManagerItemBean> mList);

        void jumpToManager(NewsManagerBean mBean);
    }

    interface Presenter extends BasePresenter<View> {

        void initManagerList();

        void setManagerList();
    }
}
