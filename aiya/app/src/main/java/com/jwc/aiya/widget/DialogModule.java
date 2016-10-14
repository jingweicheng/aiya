package com.jwc.aiya.widget;

import android.content.Context;


import dagger.Module;
import dagger.Provides;

@Module
public class DialogModule {

    Context context;

    public DialogModule(Context context){
        this.context = context;
    }

    @Provides
    LoadProgressDialog provideLoadProgressDialog(){
        return LoadProgressDialog.newInstance(context);
    }
}
