package com.si.mynews.base;/*
 * ==============================================================================
 *
 * 版 权 : ****
 *
 * 作 者 : 司 向 前
 *
 * 版 本 : 1.0
 *
 * 创建日期 : 2017/2/26 15:52
 *
 * 描 述 : Presenter基类
 *
 *
 *
 * 修订历史 :
 *
 * ==============================================================================
 */


import com.si.mynews.presenter.contract.BaseView;

public interface BasePresenter<T extends BaseView>{

    void attachView(T view);

    void detachView();
}
