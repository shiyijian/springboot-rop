package com.center.ropcenter.utils;

import com.center.ropcenter.action.BaseRequest;
import com.center.ropcenter.action.Request;
import com.commons.constant.ActionEnum;

public class RequestUtil {

    public static Request genRequest(ActionEnum command) {
        Request request = new BaseRequest();
        request.setCommand(command.getActionName());
        return request;
    }
}
