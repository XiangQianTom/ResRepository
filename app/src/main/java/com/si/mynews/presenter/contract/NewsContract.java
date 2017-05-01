package com.si.mynews.presenter.contract;

import com.si.mynews.base.BasePresenter;
import com.si.mynews.model.bean.NewsListBean;
import com.si.mynews.model.bean.NewsTopListBean;

import java.util.List;

/**
 * Created by si on 16/11/27.
 */

public interface NewsContract {

    interface View extends BaseView {

        void showTopContent(List<NewsTopListBean.DataBean> newsTopListBeen);

        void doInterval(int currentCount);

        void showContent(List<NewsListBean.ListBean> newsListBean);

        void showMoreContent(List<NewsListBean.ListBean> newsMoreListBean, int start, int end);
    }

    interface Presenter extends BasePresenter<View> {

        void getNewsTopData(String mNewsType);

        void startInterval();

        void stopInterval();

        void getNewsData(String type);

        void getMoreNewsData();
    }
}
