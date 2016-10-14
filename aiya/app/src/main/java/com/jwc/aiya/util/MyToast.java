package com.jwc.aiya.util;


import android.content.Context;
import android.widget.Toast;

public class MyToast {

    private static Toast toast;


    public MyToast() {
        super();
    }

    public static void show(Context context, CharSequence text) {
        if (MyToast.toast == null) {
            MyToast.toast = new Toast(context);
            MyToast.toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        }
        MyToast.toast.setText(text);
        MyToast.toast.show();
    }


    public static void show(Context context, CharSequence text, int duration) {
        if (MyToast.toast == null) {
            MyToast.toast = new Toast(context);
            MyToast.toast = Toast.makeText(context, text, duration);
        }

        MyToast.toast.setDuration(duration);
        MyToast.toast.setText(text);
        MyToast.toast.show();
    }

    public static void show(Context context, int resId, int duration) {
        if (MyToast.toast == null) {
            MyToast.toast = new Toast(context);
            MyToast.toast = Toast.makeText(context, resId, duration);
        }
        MyToast.toast.setDuration(duration);
        MyToast.toast.setText(context.getString(resId));
        MyToast.toast.show();
    }
}

