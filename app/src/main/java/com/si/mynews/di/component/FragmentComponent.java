package com.si.mynews.di.component;

import android.app.Activity;

import com.si.mynews.di.module.FragmentModule;
import com.si.mynews.di.scope.FragmentScope;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

}
