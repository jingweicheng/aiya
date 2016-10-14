package com.jwc.aiya.view.account.login;

import com.jwc.aiya.base.BasePresenter;
import com.jwc.aiya.base.BaseView;

/**
 * Created by jwc on 2016/10/12.
 */
public class LoginContract {
    interface Presenter extends BasePresenter{
        void login(String username,String password);
    }

    interface View extends BaseView<Presenter>{
        void loginSuccess();
        void loginError();
        void showLoadding();
        void hideLoadding();
    }
}
