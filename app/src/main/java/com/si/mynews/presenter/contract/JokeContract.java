package com.si.mynews.presenter.contract;

import com.si.mynews.model.bean.JokeListBean;

import java.util.List;

/*
 * ==============================================================================
 *
 * 版 权 : ****
 *
 * 作 者 : 司 向 前
 *
 * 版 本 : 1.0
 *
 * 创建日期 : 2017/5/4 0:05
 *
 * 描 述 :
 *
 *
 *
 * 修订历史 :
 *
 * ==============================================================================
 */
public interface JokeContract {
    interface View extends BaseView {
        void showContent(List<JokeListBean.ListBean> listBean);

        void doAutoSpeak();

    }

    interface Presenter {
        void getJokeData();

        void startAutoSpeak();

        void stopAutoSpeak();
    }
}
