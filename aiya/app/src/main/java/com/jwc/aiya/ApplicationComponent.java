package com.jwc.aiya;

import android.content.Context;

import com.jwc.aiya.api.ApiService;

import dagger.Component;

/**
 * Created by jwc on 2016/10/12.
 */
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    Context getContext();

    ApiService getApiService();
}
