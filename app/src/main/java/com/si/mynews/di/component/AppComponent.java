package com.si.mynews.di.component;

import com.si.mynews.app.App;
import com.si.mynews.di.module.AppModule;
import com.si.mynews.model.db.RealmHelper;
import com.si.mynews.model.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by si on 16/8/7.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    App getContext();  // 提供App的Context

    RetrofitHelper retrofitHelper();  //提供http的帮助类

    RealmHelper realmHelper();    //提供数据库帮助类

}
