package com.jwc.aiya.widget;


import dagger.Component;

/**
 * Created by jwc on 2016/10/12.
 */
@Component(modules = {DialogModule.class})
public interface DialogComponent {
    LoadProgressDialog getLoadProgressDialog();
}
