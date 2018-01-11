package com.web.ropboot.interceptor;

import com.rop.AbstractInterceptor;
import com.rop.RopRequestContext;

public class AppInterceptor extends AbstractInterceptor{

    @Override
    public void beforeService(RopRequestContext ropRequestContext) {

    }

    @Override
    public boolean isMatch(RopRequestContext ropRequestContext) {
        return true;
    }
}
