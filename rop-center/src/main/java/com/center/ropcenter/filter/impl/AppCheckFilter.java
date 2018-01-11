package com.center.ropcenter.filter.impl;


import com.center.ropcenter.action.RequestContext;
import com.center.ropcenter.exception.ServerException;
import com.center.ropcenter.filter.Filter;
import java.util.List;


public class AppCheckFilter implements Filter {

    private List<String> freeActions;

    public AppCheckFilter(){
        //以下几个支付回调，直接放行
    }

	@Override
	public boolean isAccept(RequestContext ctx) {
		return true;
	}

	@Override
	public boolean before(RequestContext ctx) throws ServerException {

        return true;

    }

	@Override
	public boolean after(RequestContext ctx) throws ServerException {
        return true;
	}
}
