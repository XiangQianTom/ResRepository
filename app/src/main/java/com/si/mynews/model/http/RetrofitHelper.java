package com.si.mynews.model.http;


import com.si.mynews.BuildConfig;
import com.si.mynews.app.Constants;
import com.si.mynews.model.bean.JokeListBean;
import com.si.mynews.model.bean.NewsListBean;
import com.si.mynews.model.bean.NewsTopListBean;
import com.si.mynews.model.bean.WXItemBean;
import com.si.mynews.model.bean.WelcomeBean;
import com.si.mynews.model.http.api.JokeApis;
import com.si.mynews.model.http.api.NewsApis;
import com.si.mynews.model.http.api.WeChatApis;
import com.si.mynews.model.http.api.ZhihuApis;
import com.si.mynews.model.http.response.JiSuHttpResponse;
import com.si.mynews.model.http.response.WXHttpResponse;
import com.si.mynews.util.SystemUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;


/**
 * Created by si on 2016/8/3.
 */
public class RetrofitHelper {

    private static OkHttpClient okHttpClient = null;
    private static ZhihuApis zhihuApiService = null;
    private static NewsApis newsApiService = null;
    private NewsApis newsTopApiService = null;
    private JokeApis jokeApiService = null;
    private static WeChatApis wechatApiService = null;

    public RetrofitHelper() {
        init();
    }

    private void init() {
        initOkHttp();
        zhihuApiService = getApiService(ZhihuApis.HOST, ZhihuApis.class);
        newsApiService = getApiService(NewsApis.HOST, NewsApis.class);
        newsTopApiService = getApiService(NewsApis.HOST_TOP, NewsApis.class);
        jokeApiService = getApiService(JokeApis.HOST, JokeApis.class);
        wechatApiService = getApiService(WeChatApis.HOST, WeChatApis.class);
    }

    private static void initOkHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            // https://drakeet.me/retrofit-2-0-okhttp-3-0-config
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(loggingInterceptor);
        }
        // http://www.jianshu.com/p/93153b34310e
        File cacheFile = new File(Constants.PATH_CACHE);
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!SystemUtil.isNetworkConnected()) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                if (SystemUtil.isNetworkConnected()) {
                    int maxAge = 0;
                    // 有网络时, 不缓存, 最大保存时长为0
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Pragma")
                            .build();
                } else {
                    // 无网络时，设置超时为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }
                return response;
            }
        };
//        Interceptor apikey = new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//                request = request.newBuilder()
//                        .addHeader("apikey",Constants.KEY_API_TIANXING)
//                        .build();
//                return chain.proceed(request);
//            }
//        }
//        设置统一的请求头部参数
//        builder.addInterceptor(apikey);
        //设置缓存
        builder.addNetworkInterceptor(cacheInterceptor);
        builder.addInterceptor(cacheInterceptor);
        builder.cache(cache);
        //设置超时
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        okHttpClient = builder.build();
    }

    private <T> T getApiService(String baseUrl, Class<T> clz) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(clz);
    }

    public Observable<WelcomeBean> fetchWelcomeInfo(String res) {
        return zhihuApiService.getWelcomeInfo(res);
    }

    public Observable<WXHttpResponse<List<WXItemBean>>> fetchWechatListInfo(int num, int page) {
        return wechatApiService.getWXHot(Constants.KEY_API_TIANXING, num, page);
    }

    public Observable<JiSuHttpResponse<NewsListBean>> fetchNewsList(String channel, int start, int num) {
        return newsApiService.getNews(channel, start, num, Constants.KEY_API_JISU);
    }

    public Observable<JiSuHttpResponse<NewsTopListBean>> fetchNewsList(String type) {
        return newsTopApiService.getNews(type, Constants.KEY_API_JUHE);
    }

    public Observable<JiSuHttpResponse<JokeListBean>> fetchJoke(int pageNum, int pageSize) {
        return jokeApiService.getJoke(pageNum, pageSize, JokeApis.SORT, Constants.KEY_API_JISU);
    }
}
