package com.hqu.lsw.util;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description token生成器
 * @Author shengwei.liu@luckincoffee.com
 * @Date 2019/3/1
 */
public class Token {
    public static String genetateToken(){
        String token = System.currentTimeMillis()+"";//获得毫秒数加随机数
        String tokenMd5="";
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] md5 = md.digest(token.getBytes());
            BASE64Encoder base = new BASE64Encoder();
            tokenMd5 = base.encode(md5);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return tokenMd5;
    }

}
