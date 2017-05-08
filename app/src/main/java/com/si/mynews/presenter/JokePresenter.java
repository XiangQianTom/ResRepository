package com.si.mynews.presenter;

import android.util.Log;

import com.si.mynews.base.RxPresenter;
import com.si.mynews.model.bean.JokeListBean;
import com.si.mynews.model.http.RetrofitHelper;
import com.si.mynews.model.http.response.JiSuHttpResponse;
import com.si.mynews.presenter.contract.JokeContract;
import com.si.mynews.util.RxUtil;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/*
 * ==============================================================================
 *
 * 版 权 : ****
 *
 * 作 者 : 司 向 前
 *
 * 版 本 : 1.0
 *
 * 创建日期 : 2017/5/4 0:04
 *
 * 描 述 :
 *
 *
 *
 * 修订历史 :
 *
 * ==============================================================================
 */
public class JokePresenter extends RxPresenter<JokeContract.View> implements JokeContract.Presenter {
    private static final String TAG = JokePresenter.class.getSimpleName();
    private RetrofitHelper mRetrofitHelper;
    private int mCurrentCount = 1;
    private List<JokeListBean.ListBean> mAllData=new ArrayList<>();

    @Inject
    public JokePresenter(RetrofitHelper mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }

    @Override
    public void getJokeData() {
        Subscription subscribe = mRetrofitHelper.fetchJoke(mCurrentCount++, 20)
                .compose(RxUtil.<JiSuHttpResponse<JokeListBean>>rxSchedulerHelper())
                .compose(RxUtil.<JokeListBean>handleNewsResult()).subscribe(new Action1<JokeListBean>() {
                    @Override
                    public void call(JokeListBean jokeListBean) {
                        List<JokeListBean.ListBean> list = jokeListBean.getList();
                        mAllData.addAll(list);
                        mView.showContent(mAllData);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e(TAG, "数据加载失败ヽ(≧Д≦)ノ\t" + throwable.getMessage());
                    }
                });
        addSubscrebe(subscribe);
    }

    @Override
    public void startAutoSpeak() {

    }

    @Override
    public void stopAutoSpeak() {

    }

}
