package com.web.ropboot.service;

import com.commons.utils.ResponseUtil;
import com.google.common.collect.Maps;
import com.rop.annotation.*;
import com.web.ropboot.request.init.SessionTokenRequest;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@ServiceMethodBean
public class InitalService {

    private static final Logger log = LoggerFactory.getLogger(InitalService.class);

    private static final String SESSION_TOKEN_PRE = "session_";

    @ServiceMethod(method = "init.getSessionToken",version = "1.0",needInSession = NeedInSessionType.NO,
            ignoreSign = IgnoreSignType.NO,needSessionToken = NeedSessionTokenType.NO)
    public Object getSessionToken(SessionTokenRequest request){
        long currentTime = System.currentTimeMillis();

        String sessionToken = DigestUtils.md5Hex(SESSION_TOKEN_PRE + currentTime);

        request.getRopRequestContext().getRopContext().getSessionManager().setSession(sessionToken);

        Map<String,String> params = Maps.newHashMap();
        params.put("sessionToken",sessionToken);

        log.info("InitalService ---> getSessionToken:[{}]",sessionToken);

        return ResponseUtil.getSuccessResponse(params);
    }
}
