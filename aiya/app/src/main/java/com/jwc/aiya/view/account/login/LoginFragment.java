package com.jwc.aiya.view.account.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.jwc.aiya.R;
import com.jwc.aiya.base.BaseFragment;
import com.jwc.aiya.util.MyLog;
import com.jwc.aiya.util.MyToast;
import com.jwc.aiya.widget.LoadProgressDialog;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jwc on 2016/10/12.
 */
public class LoginFragment extends BaseFragment implements LoginContract.View{

    private static final String TAG = LoginFragment.class.getSimpleName();

    LoginContract.Presenter mPresenter;

    @Bind(R.id.et_username)
    EditText et_username;

    @Bind(R.id.et_password)
    EditText et_password;


    LoadProgressDialog loadProgressDialog;

    public static LoginFragment newInstance(){
        LoginFragment loginFragment = new LoginFragment();
        return loginFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.mPresenter = presenter;
    }


    public void setLoadDialog(LoadProgressDialog loadDialog) {
        this.loadProgressDialog = loadDialog;
    }

    @OnClick(R.id.bt_login)
    public void login(){
        String username = et_username.getText().toString().trim();
        String password = et_password.getText().toString().trim();

        if(TextUtils.isEmpty(username)) {
            MyToast.show(getActivity(),"请输入用户名");
            return;
        }
        if(TextUtils.isEmpty(password)) {
            MyToast.show(getActivity(),"请输入密码");
            return;
        }
        mPresenter.login(username,password);
    }
    @OnClick(R.id.bt_register)
    public void register(){
        MyLog.d(TAG,"跳转注册页面");
        MyToast.show(getActivity(),"跳转注册页面");
    }

    @Override
    public void loginSuccess() {
        MyLog.d(TAG,"登陆成功");
        MyToast.show(getActivity(),"登陆成功");
    }

    @Override
    public void loginError() {
        MyLog.d(TAG,"登陆失败");
        MyToast.show(getActivity(),"登陆失败");
    }

    @Override
    public void hideLoadding() {
        if(loadProgressDialog != null){
            loadProgressDialog.dismiss();
        }
    }

    @Override
    public void showLoadding() {
        if(loadProgressDialog != null) {
            loadProgressDialog.setLoadText("登陆中...");
            loadProgressDialog.show();
        }
    }
}
