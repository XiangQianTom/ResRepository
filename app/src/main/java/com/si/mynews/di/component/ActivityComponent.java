package com.si.mynews.di.component;

import android.app.Activity;

import com.si.mynews.di.ActivityScope;
import com.si.mynews.di.module.ActivityModule;
import com.si.mynews.ui.main.activity.MainActivity;
import com.si.mynews.ui.main.activity.WelcomeActivity;

import dagger.Component;

/**
 * Created by si on 16/8/7.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(WelcomeActivity welcomeActivity);

    void inject(MainActivity mainActivity);

//    void inject(ZhihuDetailActivity zhihuDetailActivity);
//
//    void inject(ThemeActivity themeActivity);
//
//    void inject(SectionActivity sectionActivity);
//
//    void inject(RepliesActivity repliesActivity);
//
//    void inject(NodeListActivity nodeListActivity);
}
