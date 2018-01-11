package com.web.ropboot.manager;

import com.google.common.collect.Maps;
import com.rop.security.AppSecretManager;

import java.util.Map;

public class SimpleAppSecretManager implements AppSecretManager {

    private static Map<String, String> appKeySecretMap = Maps.newHashMap();

    static {
        appKeySecretMap.put("00001", "a246f042216f4f8f8be27dcdc476435f");
    }

    @Override
    public String getSecret(String appKey) {
        return appKeySecretMap.get(appKey);
    }

    @Override
    public boolean isValidAppKey(String appKey) {
        return appKeySecretMap.containsKey(appKey);
    }
}
