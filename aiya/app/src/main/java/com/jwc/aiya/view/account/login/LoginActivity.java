package com.jwc.aiya.view.account.login;

import android.os.Bundle;

import com.jwc.aiya.AiyaApplication;
import com.jwc.aiya.R;
import com.jwc.aiya.base.BaseActivity;
import com.jwc.aiya.util.ActivityUtils;
import com.jwc.aiya.widget.DaggerDialogComponent;
import com.jwc.aiya.widget.DialogModule;
import com.jwc.aiya.widget.LoadProgressDialog;

import javax.inject.Inject;

/**
 * Created by jwc on 2016/9/14.
 */
public class LoginActivity extends BaseActivity {


    @Inject
    LoginPresenter loginPresenter;

    @Inject
    LoadProgressDialog loadProgressDialog;

    private LoginFragment loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        addFragment();

        initializeInject();

        /**
         * 将注入的loadDialog设置给Fragment
         */
        loginFragment.setLoadDialog(loadProgressDialog);

    }

    /**
     * 将Fragment添加到此Activity
     */
    private void addFragment(){
        loginFragment = LoginFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),loginFragment,R.id.contentFrame);
    }

    /**
     * 初始化器
     */
    private void initializeInject(){
        DaggerLoginComponent
                .builder()
                /**
                 * 设置引用的ApplicationComponent的值
                 */
                .applicationComponent(((AiyaApplication)getApplication()).getApplicationComponent())
                /**
                 * 设置引用的dialogComponent的值
                 */
                .dialogComponent(DaggerDialogComponent.builder().dialogModule(new DialogModule(this)).build())
                /**
                 * 设置loginPresenterModule对象,传入当前实现的loginFramgment
                 */
                .loginPresenterModule(new LoginPresenterModule(loginFragment))
                /**
                 * 构建
                 */
                .build()
                /**
                 * 注入
                 */
                .inject(this);
    }
}
