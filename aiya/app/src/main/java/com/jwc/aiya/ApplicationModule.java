package com.jwc.aiya;

import android.content.Context;

import com.jwc.aiya.api.ApiService;
import com.jwc.aiya.api.ApiUrl;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jwc on 2016/10/12.
 */
@Module
public class ApplicationModule {
    private final Context mContext;

    public ApplicationModule(Context mContext) {
        this.mContext = mContext;
    }

    @Provides
    Context provideContext(){
        return mContext;
    }

    @Provides
    ApiService provideApiService(){

        /**
         * 系统日志拦截器
         */
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        /**
         * 自定义网络拦截器
         */
//        HttpLoggerInterceptor loggerInterceptor = new HttpLoggerInterceptor();

        /**
         * 使用自己创建的OkHttpCLient
         */
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
//                .addNetworkInterceptor(loggerInterceptor)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(ApiUrl.HOST_ADRESS)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())// 添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
                .build();
        return retrofit.create(ApiService.class);
    }
}
