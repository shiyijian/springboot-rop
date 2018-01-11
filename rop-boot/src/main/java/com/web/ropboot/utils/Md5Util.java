package com.web.ropboot.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Util {

    public static String genPassword(String str){
        return DigestUtils.md5Hex("jm"+DigestUtils.md5Hex("xy"+str));
    }
}
