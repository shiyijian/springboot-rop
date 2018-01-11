package com.center.ropcenter.action;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BaseRequest implements Request{

    private String command;

    private Map<String, Object> params = new HashMap<String, Object>(8);

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Set<String> getParamNames() {
        return params.keySet();
    }

    public Object getParam(String key) {
        return params.get(key);
    }

    public void setParam(String key, Object value) {
        params.put(key, value);
    }
}
