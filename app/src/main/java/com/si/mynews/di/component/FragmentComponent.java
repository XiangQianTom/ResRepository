package com.si.mynews.di.component;

import android.app.Activity;

import com.si.mynews.di.module.FragmentModule;
import com.si.mynews.di.scope.FragmentScope;
import com.si.mynews.fragment.news.NewsPagerFragment;
import com.si.mynews.fragment.news.NewsMainFragment;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    void inject(NewsMainFragment newsMainFragment);

    void inject(NewsPagerFragment newsPagerFragment);
}
