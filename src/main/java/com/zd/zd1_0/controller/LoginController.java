package com.zd.zd1_0.controller;


import com.zd.zd1_0.service.LoginService;
import com.zd.zd1_0.utils.pojo.ZDResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login")
    public ZDResult login(@RequestParam(name = "username",required = true)String username, @RequestParam(name = "passwd",required = true) String passwd){

        ZDResult zdResult = loginService.loginCheck(username, passwd);

        return zdResult;

    }

    @RequestMapping(value = "/hello")
    public Map hello(){
        Map map = new HashMap();
        map.put("hello","world");
        return map;

    }

}
