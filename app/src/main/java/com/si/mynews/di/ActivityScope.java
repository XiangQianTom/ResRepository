package com.si.mynews.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by si on 16/8/7.
 */

@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}