package com.si.mynews.di.module;

import com.si.mynews.app.App;

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

//    @Provides
//    @Singleton
//    RetrofitHelper provideRetrofitHelper() {
//        return new RetrofitHelper();
//    }
//
//    @Provides
//    @Singleton
//    RealmHelper provideRealmHelper() {
//        return new RealmHelper(application);
//    }
}
