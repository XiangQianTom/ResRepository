package com.si.mynews.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by codeest on 16/8/7.
 * 标识范围注释。一个范围注释适用于一类含有注射用构造函数和决定喷油器重复使用该类型的实例。
 * 默认情况下，如果没有范围注释，则注入器创建一个实例（通过注入类型的构造函数），使用实例进行一次注入，
 * 然后忘记它。如果存在范围注释，则注入器可以保留实例以便在以后的注入中重复使用。
 * 如果多个线程可以访问范围的实例，它的实施应该是线程安全的。执行范围本身是留给注射器。
 */

@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}
