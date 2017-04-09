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
import com.si.mynews.model.http.response.NewsHttpResponse;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface NewsApis {
    String HOST = "http://api.tianapi.com/";

    /**
     * 社会新闻
     */
    @GET("social")
    Observable<NewsHttpResponse<List<NewsListBean>>> getSocialNews(@Query("key") String keyApi, @Query("num") int num);
}
