package com.jwc.aiya.view.account.login;


import android.util.Log;

import com.jwc.aiya.bean.Result;
import com.jwc.aiya.bean.User;
import com.jwc.aiya.model.UserModel;
import com.jwc.aiya.util.AccountSecurityUtils;
import com.jwc.aiya.util.MyLog;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jwc on 2016/10/12.
 */
public class LoginPresenter implements LoginContract.Presenter {

    private static final String TAG = LoginPresenter.class.getSimpleName();

    @Inject
    UserModel userModel;

    private LoginContract.View loginView;

    @Inject
    public LoginPresenter(LoginContract.View loginView){
        this.loginView = loginView;
    }

    /**
     * 把当前创建的LoginPresenter对象设置给loginView
     * (应该是当LoginPresenter的构造方法结束后便走此方法)
     */
    @Inject
    public void setupListeners(){
        loginView.setPresenter(this);
    }

    @Override
    public void login(String username, String password) {
        loginView.showLoadding();
        userModel.getApiService().login(username,AccountSecurityUtils.encrypt(password))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Result<User>>() {
                    @Override
                    public void onCompleted() {
                        loginView.hideLoadding();
                        MyLog.d(TAG,"onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        loginView.hideLoadding();
                        MyLog.d(TAG,"onError:Throwable:e:"+e.toString());
                    }

                    @Override
                    public void onNext(Result<User> userResult) {
                        MyLog.d(TAG,"onNext");
                        if(userResult != null) {
                            if (userResult.state == Result.STATE_SUC) {
                                loginView.loginSuccess();
                                Log.d(TAG,userResult.describe);
                            } else {
                                loginView.loginError();
                                Log.d(TAG,userResult.describe);
                            }
                        }
                    }
                });
    }
}
