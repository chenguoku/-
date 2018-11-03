package com.zd.zd1_0.service;


import com.zd.zd1_0.utils.pojo.ZDResult;

public interface LoginService {

    public ZDResult loginCheck(String username, String passwd);

}
