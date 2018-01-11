package com.web.ropboot.service;

import com.commons.api.AdminRemote;
import com.commons.constant.ResponseCode;
import com.commons.model.DTO.AdminDTO;
import com.commons.reponse.Response;
import com.commons.utils.ResponseUtil;
import com.rop.annotation.*;
import com.rop.session.Session;
import com.rop.session.SimpleSession;
import com.web.ropboot.request.admin.GetAdminRequest;
import com.web.ropboot.request.admin.LogonRequest;
import com.web.ropboot.response.admin.GetAdminResponse;
import com.web.ropboot.response.admin.LogonResponse;
import com.web.ropboot.utils.Md5Util;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

@ServiceMethodBean
public class AdminService {

    private static final Logger log = LoggerFactory.getLogger(AdminService.class);

    private static final String ACCESS_TOKEN_PRE = "access_";

    @Resource
    private AdminRemote adminRemote;

    /**
     * 管理员登录，并返回登录后的access_token
     * @param request
     * @return
     */
    @ServiceMethod(method = "admin.login",version = "1.0",needInSession = NeedInSessionType.NO,
            ignoreSign = IgnoreSignType.NO,needSessionToken = NeedSessionTokenType.YES)
    public Object adminLogin(LogonRequest request){

        //登录时先通过账号获取管理员信息，查看用户是否存在
        Response<AdminDTO> response = adminRemote.getAdminByMobile(request.getMobile());

        if(!response.isSuccess()){
            return ResponseUtil.getErrorResponse(response.getCode(),response.getMessage());
        }

        AdminDTO adminDTO = response.getModule();

        if(adminDTO.getStatus().intValue() == 0){
            return ResponseUtil.getErrorResponse(ResponseCode.BIZ_E_NOT_VALID_ADMIN);
        }

        String md5Password = Md5Util.genPassword(request.getPassword());

        if(adminDTO.getPassword() == null || !adminDTO.getPassword().equals(md5Password)){
            return ResponseUtil.getErrorResponse(ResponseCode.BIZ_E_ERROR_USER_PASSWORD,"管理员密码不正确");
        }

        Session session = new SimpleSession();
        session.setAttribute("adminName",adminDTO.getName());
        session.setAttribute("adminId",adminDTO.getId());

        long currentTime = System.currentTimeMillis();
        String accessToken = DigestUtils.md5Hex(ACCESS_TOKEN_PRE + adminDTO.getId() + currentTime);

        request.getRopRequestContext().getRopContext().getSessionManager().addSession(accessToken,session);

        LogonResponse logonResponse = new LogonResponse();
        logonResponse.setAccessToken(accessToken);

        log.info("getAccessToken ---> [{}]",logonResponse.getAccessToken());

        return ResponseUtil.getSuccessResponse(logonResponse);
    }

    /**
     * 获取管理员信息
     * @param request
     * @return
     */
    @ServiceMethod(method = "admin.getInfo",version = "1.0",needInSession = NeedInSessionType.YES,
            ignoreSign = IgnoreSignType.NO,needSessionToken = NeedSessionTokenType.YES)
    public Object getAdmin(GetAdminRequest request){

        Session session = request.getRopRequestContext().getSession();

        Long adminId = Double.valueOf(session.getAttribute("adminId").toString()).longValue();

        log.info("getAdmin ---> adminId:[{}]",adminId);

        if(adminId == null || adminId.longValue() < 1){
            return ResponseUtil.getErrorResponse(ResponseCode.BIZ_E_NOT_EXIT_USER_ID);
        }

        Response<AdminDTO> response = adminRemote.getAdminById(adminId);

        if(!response.isSuccess()){
            return ResponseUtil.getErrorResponse(response.getCode(),response.getMessage());
        }

        GetAdminResponse getAdminResponse = new GetAdminResponse();
        getAdminResponse.setAdmin(response.getModule());

        return ResponseUtil.getSuccessResponse(getAdminResponse);
    }
}
