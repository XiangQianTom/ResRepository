package com.si.mynews.di.module;


import javax.annotation.Generated;
import javax.inject.Provider;

import retrofit2.Retrofit;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class HttpModule_ProvideWechatServiceFactory {
  private final HttpModule module;
  private final Provider<Retrofit> retrofitProvider;

  public HttpModule_ProvideWechatServiceFactory(HttpModule module, Provider<Retrofit> retrofitProvider) {
    assert module != null;
    this.module = module;
    assert retrofitProvider != null;
    this.retrofitProvider = retrofitProvider;
  }

}

