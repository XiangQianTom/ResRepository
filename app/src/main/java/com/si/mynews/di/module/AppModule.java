package com.si.mynews.di.module;

import com.si.mynews.app.App;
import com.si.mynews.model.http.RetrofitHelper;
import com.si.mynews.model.http.api.ZhihuApis;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    App provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    RetrofitHelper provideRetrofitHelper(ZhihuApis zhihuApiService) {
        return new RetrofitHelper(zhihuApiService);
    }
}
