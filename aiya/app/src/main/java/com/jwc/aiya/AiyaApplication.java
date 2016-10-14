package com.jwc.aiya;

import android.app.Application;

/**
 * Created by jwc on 2016/10/12.
 */
public class AiyaApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInject();
    }

    private ApplicationComponent applicationComponent;

    private void initializeInject(){
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
