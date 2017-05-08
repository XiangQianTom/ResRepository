package com.si.mynews.model.http.api;


import com.si.mynews.model.bean.JokeListBean;
import com.si.mynews.model.http.response.JiSuHttpResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 极速笑话APIs
 */
public interface JokeApis {
    String HOST = "http://api.jisuapi.com/xiaohua/";
    String SORT = "addtime";

    @GET("text")
    Observable<JiSuHttpResponse<JokeListBean>> getJoke(@Query("pagenum") int pagenum,
                                                       @Query("pagesize") int pagesize,
                                                       @Query("sort") String sort,
                                                       @Query("appkey") String appkey);
}
