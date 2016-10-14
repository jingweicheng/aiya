package com.jwc.aiya.view.account.login;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jwc on 2016/10/12.
 */
@Module
public class LoginPresenterModule {

    private LoginContract.View loginView;

    public LoginPresenterModule(LoginContract.View loginView){
        this.loginView = loginView;
    }

    @Provides
    LoginContract.View provideLoginView(){
        return loginView;
    }
}
