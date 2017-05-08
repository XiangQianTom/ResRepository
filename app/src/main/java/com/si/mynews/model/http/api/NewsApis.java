package com.si.mynews.model.http.api;

import com.si.mynews.model.bean.NewsListBean;
import com.si.mynews.model.bean.NewsTopListBean;
import com.si.mynews.model.http.response.JiSuHttpResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 新闻APIs
 */
public interface NewsApis {
    String HOST = "http://api.jisuapi.com/news/";
    String HOST_TOP = "http://v.juhe.cn/toutiao/";

    /**
     * 新闻
     */
    @GET("get")
    Observable<JiSuHttpResponse<NewsListBean>> getNews(@Query("channel") String channel, @Query("start") int start, @Query("num") int num, @Query("appkey") String appkey);

    /**
     * 滚动新闻
     */
    @GET("index")
    Observable<JiSuHttpResponse<NewsTopListBean>> getNews(@Query("type") String type, @Query("key") String key);
}
