package com.si.mynews.model.http.api;
/*
 * ==============================================================================
 * 
 * 版 权 : ****
 * 
 * 作 者 : 司 向 前
 * 
 * 版 本 : 1.0
 * 
 * 创建日期 : 2017/4/9 18:19
 * 
 * 描 述 :
 * 
 * 
 * 修订历史 :
 * 
 * ==============================================================================
 */

import com.si.mynews.model.bean.NewsListBean;
import com.si.mynews.model.bean.NewsTopListBean;
import com.si.mynews.model.http.response.NewsHttpResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface NewsApis {
    String HOST = "http://api.jisuapi.com/news/";
    String HOST_TOP = "http://v.juhe.cn/toutiao/";

    /**
     * 新闻
     */
    @GET("get")
    Observable<NewsHttpResponse<NewsListBean>> getNews(@Query("channel") String channel, @Query("start") int start, @Query("num") int num, @Query("appkey") String appkey);

    /**
     * 滚动新闻
     */
    @GET("index")
    Observable<NewsHttpResponse<NewsTopListBean>> getNews(@Query("type") String type, @Query("key") String key);
}
