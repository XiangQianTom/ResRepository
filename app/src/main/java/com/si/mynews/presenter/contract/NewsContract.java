package com.si.mynews.presenter.contract;

import com.si.mynews.base.BasePresenter;
import com.si.mynews.model.bean.NewsListBean;

import java.util.List;

/**
 * Created by si on 16/11/27.
 */

public interface NewsContract {

    interface View extends BaseView {

        void showContent(List<NewsListBean> newsListBean);

        void showMoreContent(List<NewsListBean> newsMoreListBean, int start, int end);
    }

    interface Presenter extends BasePresenter<View> {

        void getNewsData(String type);

        void getMoreNewsData();
    }
}
