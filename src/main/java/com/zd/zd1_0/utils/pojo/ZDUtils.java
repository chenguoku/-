package com.zd.zd1_0.utils.pojo;

import java.util.UUID;

/**
 * 工具类
 */
public class ZDUtils {

    public static String getToken(){
        return UUID.randomUUID().toString();
    }

}
