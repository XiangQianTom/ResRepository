package com.si.mynews.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.si.mynews.di.scope.FragmentScope;
import com.si.mynews.di.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by codeest on 16/8/7.
 * Created by si on 16/8/7.
 */

@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity() {
        return fragment.getActivity();
    }
}
