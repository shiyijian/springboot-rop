package com.center.ropcenter.action;

import com.commons.reponse.Response;

import javax.annotation.Resource;

public class BaseService {

    @Resource
    private RequestDispatcher requestDispatcher;

    /**
     * 服务端接口执行
     **/
    protected Response execute(Request request) {
        // 代理基础的request
        Response response = requestDispatcher.dispatch(new RequestAdapter(request));
        return response;
    }
}
