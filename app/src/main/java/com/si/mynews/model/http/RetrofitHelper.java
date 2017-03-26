package com.si.mynews.model.http;


import com.si.mynews.model.bean.WelcomeBean;
import com.si.mynews.model.http.api.ZhihuApis;

import rx.Observable;

/**
 * Created by codeest on 2016/8/3.
 */
public class RetrofitHelper {

    private ZhihuApis mZhihuApiService;

    public RetrofitHelper(ZhihuApis zhihuApiService) {
        this.mZhihuApiService = zhihuApiService;
    }
    public Observable<WelcomeBean> fetchWelcomeInfo(String res) {
        return mZhihuApiService.getWelcomeInfo(res);
    }
}
