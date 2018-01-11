package com.web.ropboot;

import com.google.common.collect.Maps;
import com.rop.client.DefaultRopClient;
import com.rop.client.RopClient;
import com.rop.utils.RopUtils;
import com.web.ropboot.utils.Md5Util;
import org.junit.Test;

import java.util.Map;

public class RopTestInit {

    private static String url = "http://localhost:8080/router";
    private static String app_key = "00001";
    private static String app_secret = "a246f042216f4f8f8be27dcdc476435f";

    private RopClient ropClient = new DefaultRopClient(url,app_key,app_secret);

    @Test
    public void test1(){

    }

    //签名
    @Test
    public void test2(){
        Map<String,String> params = Maps.newHashMap();
        params.put("appKey","00001");
        params.put("method","admin.getInfo");
        params.put("v","1.0");
        params.put("sessionToken","6e56a01db6adb7bb8b54af031835fd36");
        params.put("accessToken","f11fad6f7c801a003fd16c01a7a19db6");
        //params.put("mobile","18268206723");
        //params.put("password","111111");

        String signValue = RopUtils.sign(params, app_secret);

        System.out.println(signValue);
    }

    @Test
    public void test3(){
        System.out.println(Md5Util.genPassword("111111"));
    }
}
