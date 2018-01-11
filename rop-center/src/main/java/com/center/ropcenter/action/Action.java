package com.center.ropcenter.action;


import com.center.ropcenter.exception.ServerException;
import com.commons.reponse.BaseResponse;

public interface Action {

    public BaseResponse execute(RequestContext context);

    public String getName();
}
