package com.baidu.ssm45.utils;


public class IdUtils {

    public static String getId() {
        //获取秒
        long id = System.currentTimeMillis();
        //秒+随机数
        return id + "" + (int) (Math.random() * 10000);
    }

}
