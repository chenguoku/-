package com.zd.zd1_0.controller;


import com.zd.zd1_0.service.LoginService;
import com.zd.zd1_0.utils.pojo.ZDResult;
import com.zd.zd1_0.utils.pojo.ZDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    private static Cookie cookie;

    @RequestMapping(value = "/login")
    @CrossOrigin
    public ZDResult login(HttpServletResponse response, @RequestParam(name = "username",required = true)String username, @RequestParam(name = "passwd",required = true) String passwd){

        ZDResult zdResult = loginService.loginCheck(username, passwd);

        if (zdResult.getcode() == 1){
            cookie = new Cookie("token", ZDUtils.getToken());
            response.addCookie(cookie);
        }

        return zdResult;

    }

    @RequestMapping(value = "/hello")
    @CrossOrigin
    public Map hello(){
        Map map = new HashMap();
        map.put("hello","world");
        return map;
    }

}
