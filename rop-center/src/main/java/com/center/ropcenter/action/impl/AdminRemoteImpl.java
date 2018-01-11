package com.center.ropcenter.action.impl;

import com.center.ropcenter.action.BaseService;
import com.center.ropcenter.action.Request;
import com.center.ropcenter.utils.RequestUtil;
import com.commons.api.AdminRemote;
import com.commons.constant.ActionEnum;
import com.commons.model.DTO.AdminDTO;
import com.commons.reponse.Response;
import org.springframework.stereotype.Service;

@Service("adminRemote")
public class AdminRemoteImpl extends BaseService implements AdminRemote{

    @Override
    public Response<AdminDTO> getAdminByMobile(String mobile) {
        Request request = RequestUtil.genRequest(ActionEnum.GET_ADMINBYMOBILE);
        request.setParam("mobile",mobile);
        return execute(request);
    }

    @Override
    public Response<AdminDTO> getAdminById(Long adminId) {
        Request request = RequestUtil.genRequest(ActionEnum.GET_ADMINBYID);
        request.setParam("adminId",adminId);
        return execute(request);
    }
}
