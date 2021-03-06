package com.zd.zd1_0.service.impl;



import com.zd.zd1_0.entity.TUser;
import com.zd.zd1_0.entity.TUserExample;
import com.zd.zd1_0.mapper.TUserMapper;
import com.zd.zd1_0.service.LoginService;
import com.zd.zd1_0.utils.pojo.ZDResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public ZDResult loginCheck(String username, String passwd) {

        //密码加密
        passwd = stringToMD5(passwd);

        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();
        if (isEmail(username)){
            criteria.andEmailEqualTo(username);
        }else {
            criteria.andTelephoneEqualTo(username);
        }
        criteria.andPasswdEqualTo(passwd);
        List<TUser> list = tUserMapper.selectByExample(example);
        if (list.size() == 1){
            list.get(0).setPasswd("");
            return ZDResult.build(1,"成功",list.get(0));
        }

        return ZDResult.build(0,"您的用户名或者密码错误");
    }


    /**
     * 字符串 MD5 加密
     * @param string
     * @return
     */
    private String stringToMD5(String string){
        return DigestUtils.md5DigestAsHex(string.getBytes());
    }

    /**
     * 判断Email合法性
     * @param email
     * @return
     */
    private boolean isEmail(String email) {
        if (email == null)
            return false;
        String rule = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(rule);
        matcher = pattern.matcher(email);
        if (matcher.matches())
            return true;
        else
            return false;
    }
}
