package com.jwc.aiya.model;

import com.jwc.aiya.api.ApiService;

import javax.inject.Inject;

/**
 * Created by jwc on 2016/10/12.
 */
public class UserModel extends BaseModel{

    @Inject
    public UserModel(ApiService apiService){
        this.apiService = apiService;
    }
}
