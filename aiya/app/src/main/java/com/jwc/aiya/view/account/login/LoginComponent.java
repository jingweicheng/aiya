package com.jwc.aiya.view.account.login;

import com.jwc.aiya.ApplicationComponent;
import com.jwc.aiya.widget.DialogComponent;

import dagger.Component;

/**
 * Created by jwc on 2016/10/12.
 */
@Component(dependencies = {ApplicationComponent.class, DialogComponent.class},modules = {LoginPresenterModule.class})
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
