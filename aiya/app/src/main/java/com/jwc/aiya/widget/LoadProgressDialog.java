package com.jwc.aiya.widget;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.jwc.aiya.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jwc on 2016/10/13.
 */
public class LoadProgressDialog extends ProgressDialog {

    public static LoadProgressDialog newInstance(Context context){
        LoadProgressDialog loadProgressDialog = new LoadProgressDialog(context,R.style.LoadProgressDialog);
        return loadProgressDialog;
    }

    @Bind(R.id.tv_msg)
    TextView tv_msg;

    private LoadProgressDialog(Context context) {
        super(context);
    }

    private LoadProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(getContext());
    }

    private void init(Context context) {
        //设置不可取消，点击其他区域不能取消，实际中可以抽出去封装供外包设置
        setCancelable(false);
        setCanceledOnTouchOutside(false);

        setContentView(R.layout.dialog_load);
        ButterKnife.bind(this);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(params);
    }

    /**
     * 设置加载提示文字
     * @param msg
     */
    public void setLoadText(String msg){
        tv_msg.setText(msg);
    }
}
