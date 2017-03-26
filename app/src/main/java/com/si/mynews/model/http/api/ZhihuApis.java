package com.si.mynews.model.http.api;


import com.si.mynews.model.bean.WelcomeBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by codeest on 2016/8/2.
 * 知乎APIs
 */
public interface ZhihuApis {

    String HOST = "http://news-at.zhihu.com/api/4/";
    /**
     * 启动界面图片
     */
    @GET("start-image/{res}")
    Observable<WelcomeBean> getWelcomeInfo(@Path("res") String res);
}
