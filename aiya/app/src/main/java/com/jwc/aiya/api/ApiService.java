package com.jwc.aiya.api;

import com.jwc.aiya.bean.Result;
import com.jwc.aiya.bean.User;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by jwc on 2016/10/12.
 */
public interface ApiService {

    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    @GET(ApiUrl.REGISTER)
    Observable<Result<User>> register(@Query("username") String username,@Query("password") String password);

    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    @GET(ApiUrl.LOGIN)
    Observable<Result<User>> login(@Query("username") String username,@Query("password") String password);
}
