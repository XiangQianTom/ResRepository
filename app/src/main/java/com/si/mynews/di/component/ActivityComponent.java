package com.si.mynews.di.component;


import android.app.Activity;

import com.si.mynews.di.module.ActivityModule;
import com.si.mynews.di.scope.ActivityScope;
import com.si.mynews.ui.main.activity.MainActivity;
import com.si.mynews.ui.main.activity.WelcomeActivity;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(WelcomeActivity welcomeActivity);

    void inject(MainActivity mainActivity);
}
